package com.heavenhr.api.data.modelDto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Author: Kingsley Eze.
 * Project: heavenhr
 * Date: 12/25/2017.
 */
public class JobApplicationDto {

    @NotNull(message = "Related job id is required.")
    @Min(1)
    private int relatedOffer;

    @Email(message = "Please enter a valid email address.")
    @NotEmpty(message = "Candidate email is required.")
    private String candidateEmail;

    @NotEmpty(message = "Resumes is required")
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
