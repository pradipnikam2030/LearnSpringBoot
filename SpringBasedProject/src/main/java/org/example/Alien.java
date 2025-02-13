package org.example;

public class Alien {

    private Laptop lap;
    private int sal;
    public Laptop getLap() {
        return lap;
    }



    public void setLap(Laptop lap) {
        this.lap = lap;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;
    public Alien(){
        System.out.println("Alien object created");

    }

    public Alien(int age){
        System.out.println("para constructor");
        this.age = age;
    }
    public Alien (int age, int sal, Laptop lap){
        System.out.println("para constructor");
        this.age = age;
        this.sal = sal;
        this.lap = lap;
    }

    public Alien(Laptop lap){
        System.out.println("para constructor with lap");
        this.lap = lap;
    }
    public void code(){
        System.out.println("Alien is coding");
        System.out.println("Age is "+age +" Salary is "+sal);
        lap.compile();
    }


}
