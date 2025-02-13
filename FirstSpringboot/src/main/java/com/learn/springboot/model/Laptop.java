package com.learn.springboot.model;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
    @Override
    public void compile() {
        System.out.println("Laptop is compiling...");
    }
}
