package com.heavenhr.api.validators;

import com.heavenhr.api.data.modelDto.JobDto;
import com.heavenhr.api.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Author: Kingsley Eze.
 * Project: heavenhr
 * Date: 12/25/2017.
 */

@Component
public class JobValidator implements Validator {

    @Autowired
    private JobService jobService;

    @Override
    public boolean supports(Class<?> aClass) {
        return JobDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        JobDto dto = (JobDto) o;

        if(jobService.findByName(dto.getJobTitle()) != null){
            errors.rejectValue("jobTitle", "JobDto.jobTitle", "Job title already exist!");
        }
    }
}
