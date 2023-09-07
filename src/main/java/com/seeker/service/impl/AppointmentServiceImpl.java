package com.seeker.service.impl;

import com.seeker.request.AppointmentRequest;
import com.seeker.request.AppointmentUpdateRequest;
import com.seeker.response.AppointmentResponse;
import com.seeker.entity.Appointment;
import com.seeker.repository.AppointmentRepository;
import com.seeker.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;



    @Override
@Transactional
    public AppointmentResponse save(AppointmentRequest request) {

        Appointment appointment=new Appointment();
appointment.setJobapplyername(request.getJobapplyername());
appointment.setConsultantname(request.getConsultantname());
appointment.setApplydate(request.getApplydate());
appointment.setApplytime(request.getApplytime());
appointment.setStatus(request.getStatus());
Appointment save=appointmentRepository.save(appointment);

        return convert(save);
    }

    @Override
    @Transactional
    public AppointmentResponse update(AppointmentUpdateRequest request) {

Appointment appointment = appointmentRepository.findById(request.getId()).orElse(null);
        if(appointment==null){
            return null;
        }

appointment.setId(request.getId());
appointment.setId(request.getId());
appointment.setJobapplyername(request.getJobapplyername());
appointment.setConsultantname(request.getConsultantname());
appointment.setApplydate(request.getApplydate());
appointment.setApplytime(request.getApplytime());
appointment.setStatus(request.getStatus());
Appointment updated=appointmentRepository.save(appointment);

        return (convert(updated));
    }

    @Override
    public AppointmentResponse getById(Integer id) {

       return appointmentRepository.findById(id).map(AppointmentServiceImpl::convert).orElse(null);
    }

    @Override
    public List<AppointmentResponse> getAll() {

        return  appointmentRepository.findAll()
                .stream().map(AppointmentServiceImpl::convert).collect(Collectors.toList());

    }


    @Override
    @Transactional
    public Integer delete(Integer id) {

Appointment got=appointmentRepository.findById(id).orElse(null);
        if(got==null){
            return 0;
        }

        appointmentRepository.save(got);

        return  1;
    }

private static AppointmentResponse convert(Appointment appointment){

        AppointmentResponse typeResponse=new AppointmentResponse();
typeResponse.setId(appointment.getId());
typeResponse.setJobapplyername(appointment.getJobapplyername());
typeResponse.setConsultantname(appointment.getConsultantname());
typeResponse.setApplydate(appointment.getApplydate());
typeResponse.setApplytime(appointment.getApplytime());
typeResponse.setStatus(appointment.getStatus());
        typeResponse.setId(appointment.getId());

return typeResponse;
    }
}