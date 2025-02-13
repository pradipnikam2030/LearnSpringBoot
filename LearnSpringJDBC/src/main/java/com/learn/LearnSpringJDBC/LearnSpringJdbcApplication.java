package com.learn.LearnSpringJDBC;

import com.learn.LearnSpringJDBC.model.Student;
import com.learn.LearnSpringJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class LearnSpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(LearnSpringJdbcApplication.class, args);

		Student s1 = context.getBean(Student.class);
		s1.setRollNo(1);
		s1.setName("Raj");
		s1.setMarks(90);

		StudentService studentService=context.getBean(StudentService.class);
		studentService.addStudent(s1);

	 List<Student> list = studentService.getAllStudents();
		System.out.println(list);;

	}

}
