package com.itheima.service;


import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll(int page,int size);

   public void save(Product product);
}
