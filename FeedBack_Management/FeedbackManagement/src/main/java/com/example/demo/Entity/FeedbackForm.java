package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="form")
public class FeedbackForm {
    @Id
    @Column(name="form_id")
    int formId;
    @Column(name="form_name")
    String formName;
    @Column(name="fk_form_subject")
    int SubjectId;
    @Column(name="fk_form_teacher")
    int TeacherId;
    @Column(name="fk_tracker_id")
    int TrackerId;
    @Column(name="form_status")
    String FormStatus;

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public int getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(int subjectId) {
        SubjectId = subjectId;
    }

    public int getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(int teacherId) {
        TeacherId = teacherId;
    }

    public int getTrackerId() {
        return TrackerId;
    }

    public void setTrackerId(int trackerId) {
        TrackerId = trackerId;
    }

    public String getFormStatus() {
        return FormStatus;
    }

    public void setFormStatus(String formStatus) {
        FormStatus = formStatus;
    }

    @Override
    public String toString() {
        return "FeedbackForm{" +
                "formId=" + formId +
                ", formName='" + formName + '\'' +
                ", SubjectId=" + SubjectId +
                ", TeacherId=" + TeacherId +
                ", TrackerId=" + TrackerId +
                ", FormStatus='" + FormStatus + '\'' +
                '}';
    }

    public FeedbackForm(int formId, String formName, int subjectId, int teacherId, int trackerId, String formStatus) {
        this.formId = formId;
        this.formName = formName;
        SubjectId = subjectId;
        TeacherId = teacherId;
        TrackerId = trackerId;
        FormStatus = formStatus;
    }
}
