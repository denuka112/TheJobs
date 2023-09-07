package com.seeker.service;


import com.seeker.request.ConsultantRequest;
import com.seeker.request.ConsultantUpdateRequest;
import com.seeker.response.ConsultantResponse;
import com.seeker.response.ConsultantResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsultantService {

    ConsultantResponse save(ConsultantRequest request);

    ConsultantResponse update(ConsultantUpdateRequest request);

    ConsultantResponse getById(Integer id);

    List<ConsultantResponse> getAll();


    Integer delete(Integer id);
}