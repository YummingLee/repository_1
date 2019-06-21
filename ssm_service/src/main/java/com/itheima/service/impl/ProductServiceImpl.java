package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;


    @Override
    @PermitAll
    public List<Product> findAll(int page,int size) {
        PageHelper.startPage(page, size);
        return productDao.findAll();
    }

    @Override
    @RolesAllowed("USER,ADMIN")
    public void save(Product product) {
        productDao.save(product);
    }
}
