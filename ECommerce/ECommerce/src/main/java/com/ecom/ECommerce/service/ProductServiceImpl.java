package com.ecom.ECommerce.service;

import com.ecom.ECommerce.model.Product;
import com.ecom.ECommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productRepo.findAll();
        System.out.println(productList.get(0));
        return productList;
    }
}
