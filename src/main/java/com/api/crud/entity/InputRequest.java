package com.api.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class InputRequest {
    @JsonProperty("products")
    private List<Products> products;

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "InputRequest{" +
                "products=" + products +
                '}';
    }
}
