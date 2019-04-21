package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mt_form_question")
public class FeedbackFormMapper {
    @Id
    @Column(name="fq_form_id")
    int formid;
    @Column(name ="fq_ques_id")
    int quesionid;

    @Override
    public String toString() {
        return "FeedbackFormMapper{" +
                "formid=" + formid +
                ", quesionid=" + quesionid +
                '}';
    }

    public int getFormid() {
        return formid;
    }

    public void setFormid(int formid) {
        this.formid = formid;
    }

    public int getQuesionid() {
        return quesionid;
    }

    public void setQuesionid(int quesionid) {
        this.quesionid = quesionid;
    }
}
