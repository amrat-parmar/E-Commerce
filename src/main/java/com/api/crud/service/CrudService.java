package com.api.crud.service;

import com.api.crud.entity.InputRequest;
import com.api.crud.entity.Products;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import org.hibernate.cfg.Configuration;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public interface CrudService {
    public void saveAllTheInfo(List<Products> products);
    public Products updateProduct(Long productId, Products updatedProduct);
}
