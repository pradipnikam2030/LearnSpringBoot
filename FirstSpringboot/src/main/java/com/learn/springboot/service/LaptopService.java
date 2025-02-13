package com.learn.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    public void addLaptop(){
        System.out.println("Laptop added");
    }
    public boolean isGootForProgramming(){
        return true;
    }
}
