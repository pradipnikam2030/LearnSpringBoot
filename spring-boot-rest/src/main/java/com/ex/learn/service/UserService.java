package com.ex.learn.service;

import com.ex.learn.model.User;
import com.ex.learn.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

      @Autowired
      UserRepo userRepo;

      public User saveUser(User user){
          return userRepo.save(user);
      }
}
