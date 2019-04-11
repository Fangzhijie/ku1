package com.itcast.service.impl;
import com.github.pagehelper.PageHelper;
import com.itcast.dao.Productdao;
import com.itcast.domain.Product;
import com.itcast.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;
@Service
public class ProductServiceimpl implements ProductService {
    @Autowired
    private Productdao productdao;
    public List<Product> findAll() {
        List<Product> all = productdao.findAll();
        return all;
    }
    @Override
    public void save(Product product) {
        productdao.save(product);
    }
    @Override
    public void dele(String id) {
        productdao.dele(id);
    }
    @Override
    public Product findByid(String id) {
        Product byid = productdao.findByid(id);
        return byid;
    }
    @Override
    public List<Product> findAllLimit(int page,int size) {
        PageHelper.startPage(page,size);
       return productdao.findAll();

    }
}
