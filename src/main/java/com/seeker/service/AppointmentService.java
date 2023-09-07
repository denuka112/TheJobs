package com.seeker.service;

import com.seeker.request.AppointmentRequest;
import com.seeker.request.AppointmentUpdateRequest;
import com.seeker.response.AppointmentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {

    AppointmentResponse save(AppointmentRequest request);

    AppointmentResponse update(AppointmentUpdateRequest request);

    AppointmentResponse getById(Integer id);

    List<AppointmentResponse> getAll();


    Integer delete(Integer id);
}