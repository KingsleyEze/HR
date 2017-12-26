package com.heavenhr.api.services;

import com.heavenhr.api.data.entities.Job;
import com.heavenhr.api.data.modelDto.JobDto;
import com.heavenhr.api.repositories.JobRepository;
import com.heavenhr.api.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author: Kingsley Eze.
 * Project: heavenhr
 * Date: 12/25/2017.
 */

@Service
public class JobService {


    @Autowired
    private JobRepository repository;
    @Autowired
    private JobApplicationService applicationService;

    /**
     * Persist a new job offer
     * @param job
     * @return
     */
    public Job save(Job job){

        return repository.save(job);
    }

    /**
     * Formats and creates an new job
     * @param dto
     * @return
     */
    public Job createJob(JobDto dto){

        Date date = DateUtils.parseDate(dto.getStartDate());

        Job job =  new Job();
        job.setJobTitle(dto.getJobTitle());
        job.setStartDate(date);

        return save(job);
    }

    /**
     * Returns a list of jobs
     * @return
     */
    public List<Job> jobList(){

        return repository.findAll();
    }

    /**
     * Finds job by name
     * @param title
     * @return
     */
    public Job findByName(String title){

        return repository.findByJobTitle(title);
    }

    /**
     * Finds job by id
     * @param id
     * @return
     */
    public Job findById(int id){

        return repository.findById(id);
    }

    /**
     * Returns the total number of application for a job
     * @return
     */
    public List<Job> jobListAndApplicationNumber(){

        List<Job> jobs = new ArrayList<>();
        List<Job> jobList = jobList();

        for(Job job : jobList){

            int count = applicationService
                    .getApplicationCount(job.getId());

            job.setNumberOfApplications(count);
            jobs.add(job);
        }

        return jobs;
    }


}
