package com.heavenhr.api.services;

import com.heavenhr.api.data.entities.Job;
import com.heavenhr.api.data.entities.JobApplication;
import com.heavenhr.api.data.modelDto.JobApplicationDto;
import com.heavenhr.api.enums.ApplicationStatus;
import com.heavenhr.api.repositories.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Author: Kingsley Eze.
 * Project: heavenhr
 * Date: 12/25/2017.
 */

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository repository;

    @Autowired
    private JobService jobService;

    public JobApplication save(JobApplication application){

        return repository.save(application);
    }

    /**
     * Creates new job application
     * @param dto
     * @return
     */
    public JobApplication createJobApplication(JobApplicationDto dto){

        Job job = jobService.findById(dto.getRelatedOffer());

        int temp = job.getNumberOfApplications() + 1;
            job.setNumberOfApplications(temp);
            jobService.save(job);

        JobApplication application = new JobApplication();
            application.setCandidateEmail(dto.getCandidateEmail());
            application.setRelatedOffer(job.getId());
            application.setResume(dto.getResume());
            application.setStatus(ApplicationStatus.APPLIED);

        return save(application);
    }

    /**
     * Finds job application list by job name
     * @param jobName
     * @return
     */
    public List<JobApplication> findByJobName(String jobName){

        try {

            return repository.findByRelatedOffer(jobName);

        }catch (Exception ex){

            return null;
        }
    }

    /**
     *Finds job application list by job id
     * @param jobName
     * @return
     */
    public List<JobApplication> findByJobId(int jobName){

        try {

            return repository.findByRelatedOffer(jobName);

        }catch (Exception ex){

            return null;
        }
    }


    /**
     * Gets the total number application for a job
     * @param jobId
     * @return
     */
    public int getApplicationCount(int jobId){

        List<JobApplication> appList = findByJobId(jobId);

        if(Objects.isNull(appList))
            return 0;

        return appList.size();
    }

    /**
     * Checks if a job and candidate's email already exist
     * @param jobId
     * @param email
     * @return
     */
    public JobApplication findByJobIdAndEmail(int jobId, String email){

        Job job = jobService.findById(jobId);

        return repository.findByRelatedOfferAndCandidateEmail(job.getId(), email);
    }

    /**
     * Updates the status of an application and also trigger aspect/event for notification
     * @param dto
     * @return
     */
    public JobApplication updateApplication(JobApplicationDto dto) {

        JobApplication application = findByJobIdAndEmail(dto.getRelatedOffer(), dto.getCandidateEmail());

        application.setStatus(ApplicationStatus.valueOf(dto.getStatus()));

        return save(application);
    }

    /**
     * Gets job application list
     * @return
     */
    public List<JobApplication> getApplicationList() {

        return repository.findAll();
    }

    public JobApplication findById(int id) {

        return repository.findById(id);
    }
}