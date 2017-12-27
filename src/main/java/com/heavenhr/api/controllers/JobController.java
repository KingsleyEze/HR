package com.heavenhr.api.controllers;

import com.heavenhr.api.data.entities.Job;
import com.heavenhr.api.data.modelDto.JobDto;
import com.heavenhr.api.services.JobService;
import com.heavenhr.api.utils.ErrorsUtils;
import com.heavenhr.api.validators.JobValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Kingsley Eze.
 * Project: heavenhr
 * Date: 12/25/2017.
 */

@RequestMapping("/job")
@RestController
public class JobController
{

    @Autowired
    private JobService jobService;
    @Autowired
    private JobValidator validator;

    @ResponseBody
    @GetMapping("")
    public List<Job> jobList(){

        return jobService.jobListAndApplicationNumber();
    }

    @ResponseBody
    @PostMapping(value = "/create-job")
    public ResponseEntity<Object> createJob(@RequestBody JobDto dto, BindingResult result){

        validator.validate(dto, result);

        if (result.hasErrors()) {

            List<String> errors = ErrorsUtils.getErrors(result);

            return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
        }else{

            jobService.createJob(dto);

            String message = "Created Successfully";

            return new ResponseEntity<>(message, HttpStatus.OK);
        }

    }

    @ResponseBody
    @GetMapping("/view/{id}")
    public Job viewJob(@PathVariable int id){

        return jobService.findById(id);
    }


}
