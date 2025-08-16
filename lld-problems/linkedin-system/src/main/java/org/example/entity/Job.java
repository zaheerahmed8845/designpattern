package org.example.entity;

import org.example.enums.JobStatus;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Job {
    private static final AtomicInteger ID_GEN = new AtomicInteger(1000);

    private int jobId;
    private String jobTitle;
    private LocalDateTime dateOfPosting = LocalDateTime.now();
    private String description;
    private CompanyPage company;
    private String employmentType;
    private Address location;
    private JobStatus status = JobStatus.OPEN;

    public Job(CompanyPage company, String jobTitle, String description, String employmentType, Address location) {
        this.jobId = ID_GEN.getAndIncrement();
        this.company = company;
        this.jobTitle = jobTitle;
        this.description = description;
        this.employmentType = employmentType;
        this.location = location;
    }

    public int getJobId() {
        return jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public CompanyPage getCompany() {
        return company;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus s) {
        this.status = s;
    }

    @Override
    public String toString() {
        return "Job#" + jobId + " " + jobTitle + " @ " + company.getName() + " (" + status + ")";
    }
}
