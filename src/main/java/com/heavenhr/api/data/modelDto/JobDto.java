package com.heavenhr.api.data.modelDto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Author: Kingsley Eze.
 * Project: heavenhr
 * Date: 12/25/2017.
 */
public class JobDto {

    @NotEmpty(message="Job title is required.")
    private String jobTitle;

    @NotEmpty(message = "Start date is required.")
    private String startDate;

    private int numberOfApplications;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getNumberOfApplications() {
        return numberOfApplications;
    }

    public void setNumberOfApplications(int numberOfApplications) {
        this.numberOfApplications = numberOfApplications;
    }
}
