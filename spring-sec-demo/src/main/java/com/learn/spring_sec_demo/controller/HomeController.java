package com.learn.spring_sec_demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class HomeController {

    @GetMapping("/home")
    public String getHome(HttpServletRequest httpServletRequest){
        return "home : " + httpServletRequest.getSession().getId();
    }

}
