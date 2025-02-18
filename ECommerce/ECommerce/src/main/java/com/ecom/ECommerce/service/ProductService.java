package com.ecom.ECommerce.service;

import com.ecom.ECommerce.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface ProductService {
    List<Product> getAllProducts();

    Product getProduct(int id);

    Product addProduct(Product product, MultipartFile imageFile) throws IOException;

    void deleteProduct(int id);

    Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException;

    List<Product> searchProductByKeyword(String keyword);
}
