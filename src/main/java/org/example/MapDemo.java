package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // creating question
        Question q1 = new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is Java?");

        // creating answer
        Answer answer = new Answer(343, "Java is a programming language");
        answer.setQ(q1);

        q1.setAnswer(answer);

        // session
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

        // save
        s.save(answer);
        s.save(q1);

        tx.commit();

        // fetching
        Question newQ = (Question) s.get(Question.class, 1212);
        System.out.println(newQ.getQuestion());
        System.out.println(newQ.getAnswer().getAnswer());

        factory.close();
    }
}
