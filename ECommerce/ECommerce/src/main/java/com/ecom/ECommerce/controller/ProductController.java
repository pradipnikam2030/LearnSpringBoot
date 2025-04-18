package com.ecom.ECommerce.controller;

import com.ecom.ECommerce.model.Product;
import com.ecom.ECommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){

        List<Product>  list= productService.getAllProducts();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        Product product = productService.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable int productId){
        Product product = productService.getProduct(productId);
        return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        Product newProduct = null;
        try {
            newProduct = productService.addProduct(product, imageFile);
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?>  deleteProduct(@PathVariable int id){
         productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile){
        Product updatedProduct = null;
        try {
            updatedProduct = productService.updateProduct(id, product, imageFile);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProductByKeyword(String keyword) {
        List<Product> products = productService.searchProductByKeyword(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
