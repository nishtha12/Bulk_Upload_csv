package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback_answer")
public class FeedbackAnswer {
    @Id
    @Column(name="answer_id")
    int answerid;
    @Column(name="fk_answer_id")
    int feedbackid;
    @Column(name="fk_question_id")
    int questionid;
    @Column(name="answer_mcq")
    String mcq;
    @Column(name="answer_text")
    String anstext;

    @Override
    public String toString() {
        return "FeedbackAnswer{" +
                "answerid=" + answerid +
                ", feedbackid=" + feedbackid +
                ", questionid=" + questionid +
                ", mcq='" + mcq + '\'' +
                ", anstext='" + anstext + '\'' +
                '}';
    }

    public int getAnswerid() {
        return answerid;
    }

    public void setAnswerid(int answerid) {
        this.answerid = answerid;
    }

    public int getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(int feedbackid) {
        this.feedbackid = feedbackid;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getMcq() {
        return mcq;
    }

    public void setMcq(String mcq) {
        this.mcq = mcq;
    }

    public String getAnstext() {
        return anstext;
    }

    public void setAnstext(String anstext) {
        this.anstext = anstext;
    }

    public FeedbackAnswer(int answerid, int feedbackid, int questionid, String mcq, String anstext) {
        this.answerid = answerid;
        this.feedbackid = feedbackid;
        this.questionid = questionid;
        this.mcq = mcq;
        this.anstext = anstext;
    }
}
