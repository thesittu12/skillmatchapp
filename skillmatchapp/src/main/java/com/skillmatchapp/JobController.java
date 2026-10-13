package com.skillmatchapp;


import com.skillmatchapp.entity.Job;
import com.skillmatchapp.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    // Sabhi jobs dekhne ke liye
    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Nayi job add karne ke liye
    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }
}