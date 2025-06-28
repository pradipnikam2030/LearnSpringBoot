package org.learn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        student.setId(2);
        student.setName("Ram");
        student.setMarks(97);

//        Configuration configuration = new Configuration();
//        configuration.addAnnotatedClass(org.learn.Student.class);
//        configuration.configure();

        SessionFactory factory = new Configuration().addAnnotatedClass(org.learn.Student.class).configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(student);
        transaction.commit();
        session.close();
        factory.close();

    }
}