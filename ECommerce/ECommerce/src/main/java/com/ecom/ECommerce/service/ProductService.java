package com.ecom.ECommerce.service;

import com.ecom.ECommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    List<Product> getAllProducts();
}
