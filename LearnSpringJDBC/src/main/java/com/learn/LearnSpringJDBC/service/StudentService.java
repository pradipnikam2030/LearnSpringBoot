package com.learn.LearnSpringJDBC.service;

import com.learn.LearnSpringJDBC.model.Student;
import com.learn.LearnSpringJDBC.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
     StudentRepo studentRepo;

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void addStudent(Student student) {
        studentRepo.save(student);
        System.out.println("student added");
    }



    public List<Student> getAllStudents() {
      List<Student> allStudents =  studentRepo.findAll();
        System.out.println("all student");
      return  allStudents;
    }
}
