package com.learn.LearnSpringJDBC.repo;

import com.learn.LearnSpringJDBC.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    public void save(Student student) {
    }

    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        return list;
    }
}
