package org.example;

import jakarta.persistence.*;

@Entity
public class Answer {

    @Id
    @Column(name = "a_id")
    private int answerId;
    private String answer;
    @ManyToOne
    private Question question;

    public Question getQ() {
        return question;
    }

    public void setQ(Question q) {
        this.question = q;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Answer(int answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }

    public Answer() {
    }
}
