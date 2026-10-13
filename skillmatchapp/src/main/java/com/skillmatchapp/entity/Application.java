package com.skillmatchapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private String studentName;
    private String studentEmail;
    
    private Long jobId;
    private String jobTitle;
    private String companyName;
    
    private int matchPercentage;
    private String status = "PENDING"; // PENDING, ACCEPTED, REJECTED

    public Application() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getStudentEmail() { return studentEmail; }
    public void setStudentEmail(String studentEmail) { this.studentEmail = studentEmail; }

    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public int getMatchPercentage() { return matchPercentage; }
    public void setMatchPercentage(int matchPercentage) { this.matchPercentage = matchPercentage; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}