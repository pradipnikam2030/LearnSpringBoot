package com.ecom.ECommerce.service;

import com.ecom.ECommerce.model.Product;
import com.ecom.ECommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productRepo.findAll();
        return productList;
    }

    @Override
    public Product getProduct(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(int id) {
       Product product = productRepo.findById(id).get();
       if (product.getId()==id) {
           productRepo.deleteById(id);
       }
    }

    @Override
    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        Product existingProduct = productRepo.findById(id).get();
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setProductAvailable(product.isProductAvailable());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setImageName(imageFile.getOriginalFilename());
            existingProduct.setImageType(imageFile.getContentType());
            existingProduct.setImageData(imageFile.getBytes());
            return productRepo.save(existingProduct);
        }
        return null;
    }

    @Override
    public List<Product> searchProductByKeyword(String keyword) {
        return productRepo.searchProducts(keyword);
    }
}
