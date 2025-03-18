package com.learn.spring_sec_demo.service;

import com.learn.spring_sec_demo.model.User;
import com.learn.spring_sec_demo.model.UserPrincipal;
import com.learn.spring_sec_demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
         if (user == null){
             System.out.println("404 NOT_FOUND");
             throw new  UsernameNotFoundException("404 USER_NOT_FOUND");
         }
         return new UserPrincipal(user);
    }
}
