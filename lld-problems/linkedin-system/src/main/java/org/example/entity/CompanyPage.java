package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class CompanyPage {
    private int pageId;
    private String name;
    private String description;
    private String type;
    private int companySize;
    private User createdBy;
    private List<Job> jobs = new ArrayList<>();

    public CompanyPage(int pageId, String name, String description, String type, int companySize, User createdBy) {
        this.pageId = pageId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.companySize = companySize;
        this.createdBy = createdBy;
    }

    public Job createJobPosting(String title, String description, String employmentType, Address location) {
        Job j = new Job(this, title, description, employmentType, location);
        jobs.add(j);
        return j;
    }

    public boolean deleteJobPosting(Job job) {
        return jobs.remove(job);
    }

    public String getName() {
        return name;
    }
}
