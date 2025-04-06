package com.ex.learn.controller;

import com.ex.learn.model.JobPost;
import com.ex.learn.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/private")
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping({"/", "home"})
    public String home(){
        return "Hello Home";
    }

    @GetMapping("/jobPosts")
    public ResponseEntity<?> viewAllJobs(){
          List<JobPost> jobPosts =  jobService.viewAllJobs();
          if (jobPosts == null){
              return new ResponseEntity<>("No JobPost Available", HttpStatus.NO_CONTENT);
          }
          return new ResponseEntity<>(jobPosts, HttpStatus.OK);
    }

    @GetMapping("/jobPost/{postId}")
    public ResponseEntity<?> getPost(@PathVariable int postId){
        JobPost job = jobService.getJobById(postId);
       if(job == null){
           return new ResponseEntity<>("JobPost Not Found", HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PostMapping("/jobPost")
    public ResponseEntity<?> addPost(@RequestBody JobPost jobPost){
        JobPost jobPost1 =  jobService.addJob(jobPost);
        return new ResponseEntity<>(jobPost1, HttpStatus.CREATED);
    }

    @DeleteMapping("/jobPost/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable int postId){
        boolean isDeleted =  jobService.deleteById(postId);
        if (isDeleted){
            return new ResponseEntity<>("JobPost Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("JobPost Not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobPost")
    public ResponseEntity<?> updatePost(@RequestBody JobPost jobPost){
        JobPost jobPost1 =  jobService.updateById(jobPost);
        if (jobPost1 == null){
            return new ResponseEntity<>("JobPost Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jobPost1, HttpStatus.OK);
    }

}
