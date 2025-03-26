package com.ex.learn.service;

import com.ex.learn.model.JobPost;
import com.ex.learn.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public JobRepo getJobRepo() {
        return jobRepo;
    }

    public void setJobRepo(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public JobPost addJob(JobPost jobPost){
      return jobRepo.save(jobPost);
    }

    public List<JobPost> viewAllJobs(){
        return jobRepo.findAll();
    }


    public JobPost getJobById(int postId) {
         if (jobRepo.existsById(postId)) {
             return jobRepo.findById(postId).get();
         }
         return null;
    }

    public boolean deleteById(int postId){
         if (jobRepo.existsById(postId)) {
             jobRepo.deleteById(postId);
             return true;
         }
         return false;
    }

    public JobPost updateById(JobPost jobPost) {
         if (jobRepo.existsById(jobPost.getPostId())){
             JobPost oldJobPost = jobRepo.findById(jobPost.getPostId()).get();
             oldJobPost.setPostDesc(jobPost.getPostDesc());
             oldJobPost.setPostProfile(jobPost.getPostProfile());
             oldJobPost.setPostTechStack(jobPost.getPostTechStack());
             oldJobPost.setReqExperience(jobPost.getReqExperience());
             return jobRepo.save(oldJobPost);
         }
         return null;
    }
}
