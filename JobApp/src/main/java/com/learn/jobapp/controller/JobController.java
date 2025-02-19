package com.learn.jobapp.controller;

import com.learn.jobapp.model.JobPost;
import com.learn.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin
public class JobController {

    @Autowired
    private JobService jobService;
    @GetMapping({"/", "home"})
    public String home(){
        System.out.println("calling home...");
        return "home";
    }

    @GetMapping("addjob")
    public String addJob(){
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        jobService.addJob(jobPost);
        return "success";
    }

    @GetMapping("/viewalljobs")
    public String viewJobs(Model model) {

        List<JobPost> jobPosts = jobService.viewAllJobs();
        model.addAttribute("jobPosts", jobPosts);
        return "viewalljobs";
    }

}
