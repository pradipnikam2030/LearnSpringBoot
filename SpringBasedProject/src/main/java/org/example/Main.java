package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Alien alien = (Alien) context.getBean("alien");
//        alien.setAge(10);
        System.out.println(alien.getAge());
        alien.code();

//        Alien alien2 = (Alien) context.getBean("alien");
//        System.out.println(alien2.age);
//        alien.code();

    }
}