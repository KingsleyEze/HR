package com.heavenhr.api.data.entities;

import com.heavenhr.api.enums.ApplicationStatus;

import javax.persistence.*;

/**
 * Author: Kingsley Eze.
 * Project: heavenhr
 * Date: 12/25/2017.
 */

@Entity
@Table(name = "job_applications")
public class JobApplication {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int relatedOffer;

    @Column
    private String candidateEmail;

    @Column
    private String resume;

    @Column
    private ApplicationStatus status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRelatedOffer() {
        return relatedOffer;
    }

    public void setRelatedOffer(int relatedOffer) {
        this.relatedOffer = relatedOffer;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "id=" + id +
                ", relatedOffer='" + relatedOffer + '\'' +
                ", candidateEmail='" + candidateEmail + '\'' +
                ", resume='" + resume + '\'' +
                ", status=" + status +
                '}';
    }
}
