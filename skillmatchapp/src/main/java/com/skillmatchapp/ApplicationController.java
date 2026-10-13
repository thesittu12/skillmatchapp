package com.skillmatchapp;

import com.skillmatchapp.entity.Application;
import com.skillmatchapp.Repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @PostMapping("/apply")
    public Application applyForJob(@RequestBody Application application) {
        application.setStatus("PENDING");
        return applicationRepository.save(application);
    }

    @GetMapping("/student/{studentId}")
    public List<Application> getStudentApplications(@PathVariable Long studentId) {
        return applicationRepository.findByStudentId(studentId);
    }

    @GetMapping("/job/{jobId}")
    public List<Application> getJobApplications(@PathVariable Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }

    @PutMapping("/{appId}/status")
    public Application updateStatus(@PathVariable Long appId, @RequestParam String status) {
        Application app = applicationRepository.findById(appId).orElse(null);
        if (app != null) {
            app.setStatus(status);
            return applicationRepository.save(app);
        }
        return null;
    }
}