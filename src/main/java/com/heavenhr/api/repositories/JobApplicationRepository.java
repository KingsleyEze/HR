package com.heavenhr.api.repositories;

import com.heavenhr.api.data.entities.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: Kingsley Eze.
 * Project: heavenhr
 * Date: 12/25/2017.
 */

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    List<JobApplication> findByRelatedOffer(String title);

    List<JobApplication> findByRelatedOffer(int jobId);

    JobApplication findById(int id);

    JobApplication findByRelatedOfferAndCandidateEmail(int jobId, String email);
}
