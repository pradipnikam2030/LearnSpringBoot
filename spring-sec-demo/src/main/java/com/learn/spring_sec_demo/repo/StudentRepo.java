package com.learn.spring_sec_demo.repo;

import com.learn.spring_sec_demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {


}
