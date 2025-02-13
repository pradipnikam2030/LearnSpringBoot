package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component()
public class Programmer {
     int age;



     Computer com;

//    public Programmer(int age, Computer com) {
//        this.age = age;
//        this.com = com;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//

    public Computer getCom() {
        return com;
    }

    @Autowired
    public void setCom(@Qualifier("desktop") Computer com) {
        this.com = com;
    }
//    public Computer getLap() {
//        return com;
//    }
//
//    public void setLap(Computer lap) {
//        this.com = lap;
//    }

    public void coding(){
        System.out.println("Coding...");
        com.compile();
    }

}
