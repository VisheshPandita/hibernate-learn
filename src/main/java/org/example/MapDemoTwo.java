package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemoTwo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();

        // creating emp
        Emp e1 = new Emp();
        Emp e2 = new Emp();

        e1.setEid(34);
        e1.setName("vishesh");

        e2.setEid(35);
        e2.setName("ram");

        // creating project
        Project p1 = new Project();
        Project p2 = new Project();

        p1.setPid(1212);
        p1.setProjectName("Lib management system");
        p2.setPid(1213);
        p2.setProjectName("Chat bot");

        List<Emp> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);

        List<Project> projectList = new ArrayList<>();
        projectList.add(p1);
        projectList.add(p2);

        //
        e1.setProjects(projectList);
        p2.setEmps(empList);

        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

        s.save(e1);
        s.save(e2);
        s.save(p1);
        s.save(p2);

        tx.commit();

        factory.close();
    }
}
