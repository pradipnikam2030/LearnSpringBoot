package com.ex.learn.serviceTest;

import com.ex.learn.model.JobPost;
import com.ex.learn.repo.JobRepo;
import com.ex.learn.service.JobService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class JobServiceTest {

    @InjectMocks
    private JobService jobService;
   /* @InjectMocks: This annotation is used to create an instance of the JobService class and inject the mocked dependencies
            (in this case, JobRepo) into it. This allows you to test the JobService in isolation.*/

    @Mock
    private JobRepo jobRepo;
    /*@Mock: This annotation is used to create a mock instance of the JobRepo interface. The mock will simulate the behavior
    of the actual repository without needing to connect to a real database.*/

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    /*The @BeforeEach annotation indicates that this method should be run before each test case.
    MockitoAnnotations.openMocks(this) initializes the mocks annotated with @Mock and injects them into the @InjectMocks annotated class (JobService).
    This setup ensures that each test starts with a fresh instance of JobService and its dependencies.*/

    @Test
    void getAllJobs() {
        List<JobPost> jobPosts = new ArrayList<>();
        JobPost jobPost1 = new JobPost();
        jobPost1.setPostId(1);
        jobPosts.add(jobPost1);

        when(jobRepo.findAll()).thenReturn(jobPosts);
        /*when(jobRepo.findAll()).thenReturn(jobPosts); tells Mockito to return the jobPosts list whenever the findAll
        method of the jobRepo mock is called.*/

        List<JobPost> retrievedJobPosts = jobService.viewAllJobs();

        assertNotNull(retrievedJobPosts);
        assertEquals(1, retrievedJobPosts.size());
        verify(jobRepo, times(1)).findAll();
    }

    @Test
    void getJobByIdWhenJobIdExists() {
        JobPost jobPost = new JobPost();
        jobPost.setPostId(1);
        jobPost.setPostProfile("Java Developer");
        when(jobRepo.existsById(1)).thenReturn(true);
        when(jobRepo.findById(1)).thenReturn(Optional.of(jobPost));

       /* when(jobRepo.existsById (1)).thenReturn(true); tells Mockito to return true when the existsById method is
        called with the ID 1, indicating that the job post exists.
        when(jobRepo.findById(1)).thenReturn(Optional.of(jobPost)); instructs Mockito to return an Optional
        containing the jobPost when findById is called with the ID 1.*/

        JobPost retrievedJobPost = jobService.getJobById(1);
        assertNotNull(retrievedJobPost);
        assertEquals(jobPost.getPostProfile(), retrievedJobPost.getPostProfile());
        assertEquals(1, retrievedJobPost.getPostId());
        verify(jobRepo, times(1)).findById(1);
    }


     /*write remaining testcases for update job, delete job, if jobId is not exists , if delete job id is not exists
    testUpdateByIdExists, testDeleteByIdNotExists, testDeleteByIdExists, testGetJobByIdNotExists, testGetJobByIdExists*/
}
