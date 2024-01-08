package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Student student = new Student(111,"vishesh", "Delhi");
        Certificate certificate = new Certificate("Cloud", "1 months");
        student.setCerti(certificate);

        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

        s.save(student);

        tx.commit();
        s.close();
        factory.close();
    }
}
