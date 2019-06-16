package com.itheima.dao;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
}
