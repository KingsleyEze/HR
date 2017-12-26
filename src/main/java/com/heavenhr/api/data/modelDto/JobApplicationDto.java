package com.heavenhr.api.data.modelDto;

/**
 * Author: Kingsley Eze.
 * Project: heavenhr
 * Date: 12/25/2017.
 */
public class JobApplicationDto {

    private int relatedOffer;

    private String candidateEmail;

    private String resume;

    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
