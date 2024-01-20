package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Answer {

    @Id
    @Column(name = "a_id")
    private int answerId;
    private String answer;
    @OneToOne(mappedBy = "answer")
    private Question q;

    public Question getQ() {
        return q;
    }

    public void setQ(Question q) {
        this.q = q;
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
