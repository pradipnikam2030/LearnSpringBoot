package com.ecom.ECommerce.controller;

import com.ecom.ECommerce.model.Product;
import com.ecom.ECommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    public ResponseEntity<String> home(){
        return new ResponseEntity<>("home", HttpStatus.OK);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getProducts(){

        List<Product>  list= productService.getAllProducts();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getProduct")
    public Product getProduct(){
        Product  product = new Product();
        product.setId(1);
        product.setName("test");
        return product;
    }
}
