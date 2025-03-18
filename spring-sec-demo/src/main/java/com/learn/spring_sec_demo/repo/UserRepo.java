package com.learn.spring_sec_demo.repo;

import com.learn.spring_sec_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
           User findByUsername(String username);
}
