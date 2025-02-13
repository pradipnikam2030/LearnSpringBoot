package org.example;

import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {

        // Java based configuration
         ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

          Programmer programmer = context.getBean(Programmer.class);
        System.out.println(programmer.getAge());
          programmer.coding();

//         Desktop desk = context.getBean( Desktop.class);
//         desk.compile();
//
//        Desktop desk2 = context.getBean( Desktop.class);
//        desk2.compile();



        // XML based Configuration
     /*   ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

         Programmer programmer = context.getBean( Programmer.class);
//         programmer.setAge(21);
         System.out.println(programmer.getAge());
         programmer.coding();

        Programmer programmer2 = (Programmer) context.getBean("programmer");
        System.out.println(programmer2.getAge());
        programmer2.coding();
*/
    }
}
