package com.seeker.service;


import com.seeker.request.JobapplyerRequest;
import com.seeker.request.JobapplyerUpdateRequest;
import com.seeker.response.JobapplyerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobapplyerService {

    JobapplyerResponse save(JobapplyerRequest request);

    JobapplyerResponse update(JobapplyerUpdateRequest request);

    JobapplyerResponse getById(Integer id);

    List<JobapplyerResponse> getAll();


    Integer delete(Integer id);
}