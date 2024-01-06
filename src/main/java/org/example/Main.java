package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // creating student
        Student st = new Student();
        st.setId(101);
        st.setName("vishesh");
        st.setCity("delhi");

        // creating object of address class
        Address ad = new Address();
        ad.setStreet("Street 1");
        ad.setCity("Delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(12.21);

        // reading image
        FileInputStream fis = new FileInputStream("src/main/resources/aloneInSpace.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);

        Session session = factory.openSession();

        session.beginTransaction();
        session.save(st);
        session.save(ad);
        session.getTransaction().commit();

        session.close();
    }
}