package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        // get, load
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();

        // get student
        Student student = (Student) session.get(Student.class, 101);
        System.out.println(student);

        Address ad = (Address) session.get(Address.class, 1);
        System.out.println(ad.getAddedDate());

        session.close();
        factory.close();
    }
}
