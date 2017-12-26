package com.heavenhr.api.aspects;

import com.heavenhr.api.data.modelDto.JobApplicationDto;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Author: Kingsley Eze.
 * Project: heavenhr
 * Date: 12/25/2017.
 */

@Aspect
@Component
public class JobApplicationAspect {

    //Pointcuts

    @Pointcut("execution(* com.heavenhr.api.services.JobApplicationService" +
            ".updateApplication(com.heavenhr.api.data.modelDto.JobApplicationDto)) " +
            "&& args(dto, ..)")
    public void updateNotificationMethod(JobApplicationDto dto) {}


    //Events

    @After(value = "updateNotificationMethod(dto)")
    public void updateNotification(JobApplicationDto dto){

        System.out.println("Application status has changed");
    }
}
