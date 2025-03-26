package com.learn.JobAppSec.service;

import com.learn.jobapp.model.JobPost;
import com.learn.jobapp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private JobRepo jobRepo;

    public JobRepo getJobRepo() {
        return jobRepo;
    }

    @Autowired
    public void setJobRepo(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public void addJob(JobPost jobPost){
        jobRepo.save(jobPost);
    }

    public List<JobPost> viewAllJobs(){
        return jobRepo.findAll();
    }


}
