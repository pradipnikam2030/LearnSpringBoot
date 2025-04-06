package com.learn.spring_sec_demo.service;

import com.learn.spring_sec_demo.model.Student;
import com.learn.spring_sec_demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

      @Autowired
      StudentRepo studentRepo;

    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    // Get All Students
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    // Get Student by ID
    public Optional<Student> getStudentById(int rollNo) {
        return studentRepo.findById(rollNo);
    }

    // Delete Student
    public void deleteStudent(int rollNo) {
        studentRepo.deleteById(rollNo);
    }

}
