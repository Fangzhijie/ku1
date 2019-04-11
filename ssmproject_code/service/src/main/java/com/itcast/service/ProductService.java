package com.itcast.service;

import com.itcast.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);

    void dele(String id);
    Product findByid(String id);

    List<Product> findAllLimit(int page, int size);
}
