package com.learn.spring_sec_demo.service;

import com.learn.spring_sec_demo.model.User;
import com.learn.spring_sec_demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public User saveUser( User user){
        System.out.println("in save user");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

}
