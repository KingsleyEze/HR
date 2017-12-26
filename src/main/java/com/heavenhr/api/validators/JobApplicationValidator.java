package com.heavenhr.api.validators;

import com.heavenhr.api.data.modelDto.JobApplicationDto;
import com.heavenhr.api.services.JobApplicationService;
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
public class JobApplicationValidator implements Validator {

    @Autowired
    private JobApplicationService applicationService;

    @Override
    public boolean supports(Class<?> aClass) {
        return JobApplicationDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        JobApplicationDto dto = (JobApplicationDto) o;

        if(applicationService.findByJobIdAndEmail(dto.getRelatedOffer(), dto.getCandidateEmail()) != null){
            errors.rejectValue("candidateEmail", "JobApplicationDto.candidateEmail", "Candidate has already applied!");
        }
    }
}
