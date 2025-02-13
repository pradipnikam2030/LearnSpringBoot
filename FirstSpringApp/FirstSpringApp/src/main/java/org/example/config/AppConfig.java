package org.example.config;

import org.example.Computer;
import org.example.Desktop;
import org.example.Laptop;
import org.example.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.example")
public class AppConfig {

//
//    @Bean
//    public Programmer programmer ( Computer com){  // @Qualifier("desktop")
//        Programmer programmer = new Programmer();
//        programmer.setAge(45);
//        programmer.setCom(com);
//        return  programmer;
//    }
//
//
////    @Bean("com2")
//    @Bean()
////    @Scope("prototype")
//    public Desktop desktop(){
//        return new Desktop();
//    }
//
//    @Bean
//    @Primary()
//    public Laptop laptop(){
//        return  new Laptop();
//    }

}
