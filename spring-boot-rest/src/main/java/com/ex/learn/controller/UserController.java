package com.ex.learn.controller;

import com.ex.learn.model.User;
import com.ex.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
     UserService userService;

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

}
