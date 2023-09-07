package com.seeker.controller;


import  com.seeker.request.JobapplyerRequest;
import  com.seeker.request.JobapplyerUpdateRequest;
import  com.seeker.response.JobapplyerResponse;
import  com.seeker.service.JobapplyerService;

import com.seeker.service.JobapplyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("Jobapplyer")
@RestController
@CrossOrigin
public class JobapplyerController {

    @Autowired
    private JobapplyerService jobapplyerService;


    @PostMapping
    public ResponseEntity<JobapplyerResponse> save(@Valid @RequestBody JobapplyerRequest request){
        JobapplyerResponse save = jobapplyerService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<JobapplyerResponse> update(@Valid @RequestBody JobapplyerUpdateRequest request){
        JobapplyerResponse updated = jobapplyerService.update(request);
        if(updated==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }


    @GetMapping("{id}")
    public ResponseEntity<JobapplyerResponse> getById(@PathVariable("id") @NotBlank Integer id){
        JobapplyerResponse get = jobapplyerService.getById(id);

        if(get==null){

            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(get);
    }


    @GetMapping()
    public ResponseEntity<List<JobapplyerResponse>> getAll(){
        List<JobapplyerResponse> getall = jobapplyerService.getAll();
        return ResponseEntity.ok(getall);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") @NotBlank Integer id){
        int deleted = jobapplyerService.delete(id);
        if(deleted==0){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
}