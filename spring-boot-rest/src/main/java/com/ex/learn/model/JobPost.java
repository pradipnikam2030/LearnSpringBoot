package com.ex.learn.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "jobpost")
public class JobPost {
    @Id
    @Column(name = "postId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    @Column(name = "postProfile")
    private String postProfile;
    @Column(name = "postDesc")
    private String postDesc;
    @Column(name = "reqExperience")
    private Integer reqExperience;
    @ElementCollection
    @CollectionTable(name = "techStack", joinColumns = @JoinColumn(name = "postId"))
    @Column(name = "postTechStack")
    private List<String> postTechStack;

    public JobPost() {
    }

    public JobPost(String postProfile, String postDesc, Integer reqExperience, List<String> postTechStack) {
        this.postProfile = postProfile;
        this.postDesc = postDesc;
        this.reqExperience = reqExperience;
        this.postTechStack = postTechStack;
    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostProfile() {
        return postProfile;
    }

    public void setPostProfile(String postProfile) {
        this.postProfile = postProfile;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public Integer getReqExperience() {
        return reqExperience;
    }

    public void setReqExperience(Integer reqExperience) {
        this.reqExperience = reqExperience;
    }

    public List<String> getPostTechStack() {
        return postTechStack;
    }

    public void setPostTechStack(List<String> postTechStack) {
        this.postTechStack = postTechStack;
    }
}
