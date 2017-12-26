package com.heavenhr.api.controllers;

import com.heavenhr.api.data.entities.JobApplication;
import com.heavenhr.api.data.modelDto.JobApplicationDto;
import com.heavenhr.api.services.JobApplicationService;
import com.heavenhr.api.validators.JobApplicationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Kingsley Eze.
 * Project: heavenhr
 * Date: 12/25/2017.
 */

@RequestMapping("/application")
@RestController
public class JobApplicationController {

    @Autowired
    private JobApplicationService applicationService;
    @Autowired
    private JobApplicationValidator validator;

    @ResponseBody
    @GetMapping("")
    public List<JobApplication> getApplicationList(){

        return applicationService.getApplicationList();
    }

    @ResponseBody
    @GetMapping("/job/{jobId}")
    public List<JobApplication> getJobApplicationList(@PathVariable int jobId) {

        return applicationService.findByJobId(jobId);
    }

    @ResponseBody
    @GetMapping("/view/{id}")
    public JobApplication getJobApplication(@PathVariable int id) {

        return applicationService.findById(id);
    }

    @ResponseBody
    @PostMapping("/apply")
    public ResponseEntity<Object> applyJob(@RequestBody JobApplicationDto dto, BindingResult result){

        validator.validate(dto, result);

        if (result.hasErrors()) {

            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
        }else{

            applicationService.createJobApplication(dto);

            String message = "Application was sent successfully";

            return new ResponseEntity<>(message, HttpStatus.OK);
        }

    }

    @ResponseBody
    @GetMapping("/count/{jobId}")
    public int jobApplicationCount(@PathVariable int jobId){

        return applicationService.getApplicationCount(jobId);
    }

    @ResponseBody
    @PutMapping("/update-status")
    public JobApplication updateApplicationStatus(@RequestBody JobApplicationDto dto){

        return applicationService.updateApplication(dto);
    }


}
