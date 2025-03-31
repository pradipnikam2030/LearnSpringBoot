package com.ex.learn.service;

import com.ex.learn.model.User;
import com.ex.learn.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

      @Autowired
      UserRepo userRepo;

      private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

      public User saveUser(User user){
          System.out.println("in save user");
//          user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
          return userRepo.save(user);
      }
}
