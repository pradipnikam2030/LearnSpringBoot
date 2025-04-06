package com.learn.spring_sec_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
      private  int rollNo;
      private String firstName;
      private String lastName;
      private int marks;

    public Student() {
    }

    public Student(int rollNo, String firstName, String lastName, int marks) {
        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
