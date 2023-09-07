package com.seeker.controller;



import com.seeker.request.AppointmentRequest;
import com.seeker.request.AppointmentUpdateRequest;
import com.seeker.response.AppointmentResponse;
import  com.seeker.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("Appointment")
@RestController
@CrossOrigin
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;


    @PostMapping
    public ResponseEntity<AppointmentResponse> save(@Valid @RequestBody AppointmentRequest request){
        AppointmentResponse save = appointmentService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<AppointmentResponse> update(@Valid @RequestBody AppointmentUpdateRequest request){
        AppointmentResponse updated = appointmentService.update(request);
        if(updated==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }


    @GetMapping("{id}")
    public ResponseEntity<AppointmentResponse> getById(@PathVariable("id") @NotBlank Integer id){
        AppointmentResponse get = appointmentService.getById(id);

        if(get==null){

            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(get);
    }


    @GetMapping()
    public ResponseEntity<List<AppointmentResponse>> getAll(){
        List<AppointmentResponse> getall = appointmentService.getAll();
        return ResponseEntity.ok(getall);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") @NotBlank Integer id){
        int deleted = appointmentService.delete(id);
        if(deleted==0){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
}