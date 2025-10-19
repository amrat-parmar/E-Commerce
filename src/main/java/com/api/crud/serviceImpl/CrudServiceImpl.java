package com.api.crud.serviceImpl;

import com.api.crud.entity.Products;
import com.api.crud.repo.ProductRepository;
import com.api.crud.service.CrudService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.LockModeType;
import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrudServiceImpl implements CrudService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager entityManager;

    private static final Logger log = LoggerFactory.getLogger(CrudServiceImpl.class);

@Transactional
    @Override
    public void saveAllTheInfo(List<Products> products) {
        try {
            if (products.get(0).getId() == 0 || !productRepository.existsById(products.get(0).getId())) {
                log.info("🚀 Inserting new product into DB: {}", products.get(0));
                productRepository.save(products.get(0)); // 🔥 Force INSERT if new
            } else {
                log.info("🔄 Updating existing product in DB: {}", products.get(0));
                Products existingProduct = entityManager.find(Products.class, products.get(0).getId());
                entityManager.refresh(existingProduct);
                existingProduct.setVersion(existingProduct.getVersion() + 1);
                entityManager.merge(existingProduct);
            }
            entityManager.flush(); // 💡 Ensures immediate commit to DB
            entityManager.clear();

        } catch (OptimisticLockException e) {
            log.warn("Optimistic locking conflict! Retrying...");
            throw new RuntimeException("Concurrent update detected, please try again.");

        }
    }

    @Override
    public Products updateProduct(Long productId, Products updatedProduct) {
        Products existingProduct = entityManager.find(Products.class, productId);

        if (existingProduct == null) {
            throw new EntityNotFoundException("Product not found!");
        }

        entityManager.refresh(existingProduct);
        entityManager.lock(existingProduct, LockModeType.OPTIMISTIC);

        existingProduct.setTitle(updatedProduct.getTitle());
        existingProduct.setPrice(updatedProduct.getPrice());

        return entityManager.merge(existingProduct);
    }
}