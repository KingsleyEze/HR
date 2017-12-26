package com.heavenhr.api.repositories;

import com.heavenhr.api.data.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Kingsley Eze.
 * Project: heavenhr
 * Date: 12/25/2017.
 */

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    Job findByJobTitle(String title);

    Job findById(int id);
}
