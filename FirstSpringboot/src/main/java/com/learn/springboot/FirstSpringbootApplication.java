package com.learn.springboot;

import com.learn.springboot.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstSpringbootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FirstSpringbootApplication.class, args);

		LaptopService laptopService = context.getBean(LaptopService.class);
		laptopService.addLaptop();

		/*Alien alien = context.getBean(Alien.class);
		System.out.println(alien.getAge());
		alien.coding();*/

	}

}
