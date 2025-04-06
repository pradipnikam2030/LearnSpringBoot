package com.learn.spring_sec_demo.controller;

import com.learn.spring_sec_demo.model.Student;
import com.learn.spring_sec_demo.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/home")
    public String getHome(HttpServletRequest httpServletRequest){
        return "home : " + httpServletRequest.getSession().getId();
    }

    // Create or Update Student
    @PostMapping("/add-student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    // Get All Students
    @GetMapping("/all-students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // Get Student by ID
    @GetMapping("/{rollNo}")
    public ResponseEntity<Student> getStudentById(@PathVariable int rollNo) {
        Optional<Student> student = studentService.getStudentById(rollNo);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Student
    @DeleteMapping("/{rollNo}")
    public ResponseEntity<String> deleteStudent(@PathVariable int rollNo) {
        studentService.deleteStudent(rollNo);
        return ResponseEntity.ok("Student deleted successfully");
    }

}
