package com.raksh.Spring_Boot_Rest.controller;

import com.raksh.Spring_Boot_Rest.model.JobPost;
import com.raksh.Spring_Boot_Rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs") // Optional: Add a base path for your job-related endpoints
public class JobRestController {

    private final JobService js;

    @Autowired
    public JobRestController(JobService js) {
        this.js = js;
    }

    @GetMapping
    public List<JobPost> getAllJobs() {
        return js.getAll();
    }

    @GetMapping("/{jobId}")
    public JobPost getJob(@PathVariable int jobId) {
        return js.getJobById(jobId);
    }

    @PostMapping
    public void addJob(@RequestBody JobPost jp) {
        js.addJob(jp);
    }

    @PutMapping("/{jobId}")
    public JobPost updateJob(@PathVariable int jobId, @RequestBody JobPost jp) {
        js.updateJob(jobId, jp);
        return js.getJobById(jobId);
    }

    @DeleteMapping("/{jobId}")
    public void deleteJob(@PathVariable int jobId) {
        js.deleteJob(jobId);
    }
}
