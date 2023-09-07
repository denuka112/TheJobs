package com.seeker.service.impl;


import com.seeker.request.JobapplyerRequest;
import com.seeker.request.JobapplyerUpdateRequest;
import com.seeker.response.JobapplyerResponse;
import com.seeker.entity.Jobapplyer;
import com.seeker.repository.JobapplyerRepository;
import com.seeker.service.JobapplyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobapplyerServiceImpl implements JobapplyerService {

    @Autowired
    private JobapplyerRepository jobapplyerRepository;



    @Override
@Transactional
    public JobapplyerResponse save(JobapplyerRequest request) {

        Jobapplyer jobapplyer=new Jobapplyer();
jobapplyer.setName(request.getName());
jobapplyer.setAddress(request.getAddress());
jobapplyer.setNic(request.getNic());
jobapplyer.setGender(request.getGender());
jobapplyer.setDob(request.getDob());
jobapplyer.setSchool(request.getSchool());
Jobapplyer save=jobapplyerRepository.save(jobapplyer);

        return convert(save);
    }

    @Override
    @Transactional
    public JobapplyerResponse update(JobapplyerUpdateRequest request) {

Jobapplyer jobapplyer = jobapplyerRepository.findById(request.getId()).orElse(null);
        if(jobapplyer==null){
            return null;
        }

jobapplyer.setId(request.getId());
jobapplyer.setId(request.getId());
jobapplyer.setName(request.getName());
jobapplyer.setAddress(request.getAddress());
jobapplyer.setNic(request.getNic());
jobapplyer.setGender(request.getGender());
jobapplyer.setDob(request.getDob());
jobapplyer.setSchool(request.getSchool());
Jobapplyer updated=jobapplyerRepository.save(jobapplyer);

        return (convert(updated));
    }

    @Override
    public JobapplyerResponse getById(Integer id) {

       return jobapplyerRepository.findById(id).map(JobapplyerServiceImpl::convert).orElse(null);
    }

    @Override
    public List<JobapplyerResponse> getAll() {

        return  jobapplyerRepository.findAll()
                .stream().map(JobapplyerServiceImpl::convert).collect(Collectors.toList());

    }


    @Override
    @Transactional
    public Integer delete(Integer id) {

Jobapplyer got=jobapplyerRepository.findById(id).orElse(null);
        if(got==null){
            return 0;
        }

        jobapplyerRepository.save(got);

        return  1;
    }

private static JobapplyerResponse convert(Jobapplyer jobapplyer){

        JobapplyerResponse typeResponse=new JobapplyerResponse();
typeResponse.setId(jobapplyer.getId());
typeResponse.setName(jobapplyer.getName());
typeResponse.setAddress(jobapplyer.getAddress());
typeResponse.setNic(jobapplyer.getNic());
typeResponse.setGender(jobapplyer.getGender());
typeResponse.setDob(jobapplyer.getDob());
typeResponse.setSchool(jobapplyer.getSchool());
        typeResponse.setId(jobapplyer.getId());

return typeResponse;
    }
}