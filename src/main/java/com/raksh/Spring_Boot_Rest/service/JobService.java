package com.raksh.Spring_Boot_Rest.service;

import com.raksh.Spring_Boot_Rest.model.JobPost;
import com.raksh.Spring_Boot_Rest.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepo jr;

    @Autowired
    public JobService(JobRepo jr) {
        this.jr = jr;
    }

    public void addJob(JobPost jobPost){
        jr.save(jobPost); // Using JpaRepository's save() method to add a job
    }

    public List<JobPost> getAll() {
        return jr.findAll(); // Using JpaRepository's findAll() method to get all job posts
    }

    public JobPost getJobById(int jobId) {
        return jr.findById(jobId).orElse(null); // Using JpaRepository's findById() method to find by ID
    }

    public void updateJob(int jobId, JobPost jp) {
        if (jr.existsById(jobId)) {
            jp.setPostId(jobId);  // Make sure the ID is set properly
            jr.save(jp);  // Using JpaRepository's save() method to update the job
        }
    }

    public void deleteJob(int jobId) {
        jr.deleteById(jobId); // Using JpaRepository's deleteById() method to delete the job
    }
}
