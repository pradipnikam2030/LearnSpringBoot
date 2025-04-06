package com.learn.spring_sec_demo.controller;


import com.learn.spring_sec_demo.model.User;
import com.learn.spring_sec_demo.service.JwtService;
import com.learn.spring_sec_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    JwtService jwtService;

    @PostMapping("/add-user")
    public User addNewUser(@RequestBody User user){

        return userService.saveUser(user);

    }

    @PostMapping("/login")
    public String authenticateUser(@RequestBody User user){
     Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

       if (authentication.isAuthenticated())
         return  jwtService.generateToken(user.getUsername());
       else
           return "failed";
    }

}
