package com.seeker.controller;


import  com.seeker.request.ConsultantRequest;
import  com.seeker.request.ConsultantUpdateRequest;
import  com.seeker.response.ConsultantResponse;
import  com.seeker.service.ConsultantService;

import com.seeker.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("Consultant")
@RestController
@CrossOrigin
public class ConsultantController {

    @Autowired
    private ConsultantService consultantService;


    @PostMapping
    public ResponseEntity<ConsultantResponse> save(@Valid @RequestBody ConsultantRequest request){
        ConsultantResponse save = consultantService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<ConsultantResponse> update(@Valid @RequestBody ConsultantUpdateRequest request){
        ConsultantResponse updated = consultantService.update(request);
        if(updated==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }


    @GetMapping("{id}")
    public ResponseEntity<ConsultantResponse> getById(@PathVariable("id") @NotBlank Integer id){
        ConsultantResponse get = consultantService.getById(id);

        if(get==null){

            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(get);
    }


    @GetMapping()
    public ResponseEntity<List<ConsultantResponse>> getAll(){
        List<ConsultantResponse> getall = consultantService.getAll();
        return ResponseEntity.ok(getall);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") @NotBlank Integer id){
        int deleted = consultantService.delete(id);
        if(deleted==0){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
}