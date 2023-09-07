package com.seeker.service.impl;


import com.seeker.request.ConsultantRequest;
import com.seeker.request.ConsultantUpdateRequest;
import com.seeker.response.ConsultantResponse;
import com.seeker.entity.Consultant;
import com.seeker.repository.ConsultantRepository;
import com.seeker.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultantServiceImpl implements ConsultantService {

    @Autowired
    private ConsultantRepository consultantRepository;



    @Override
@Transactional
    public ConsultantResponse save(ConsultantRequest request) {

        Consultant consultant=new Consultant();
consultant.setName(request.getName());
consultant.setAdress(request.getAdress());
consultant.setTp(request.getTp());
consultant.setGender(request.getGender());
consultant.setNic(request.getNic());
consultant.setDob(request.getDob());

Consultant save=consultantRepository.save(consultant);

        return convert(save);
    }

    @Override
    @Transactional
    public ConsultantResponse update(ConsultantUpdateRequest request) {

Consultant consultant = consultantRepository.findById(request.getId()).orElse(null);
        if(consultant==null){
            return null;
        }

consultant.setId(request.getId());
consultant.setId(request.getId());
consultant.setName(request.getName());
consultant.setAdress(request.getAdress());
consultant.setTp(request.getTp());
consultant.setGender(request.getGender());
consultant.setNic(request.getNic());
consultant.setDob(request.getDob());
Consultant updated=consultantRepository.save(consultant);

        return (convert(updated));
    }

    @Override
    public ConsultantResponse getById(Integer id) {

       return consultantRepository.findById(id).map(ConsultantServiceImpl::convert).orElse(null);
    }

    @Override
    public List<ConsultantResponse> getAll() {

        return  consultantRepository.findAll()
                .stream().map(ConsultantServiceImpl::convert).collect(Collectors.toList());

    }


    @Override
    @Transactional
    public Integer delete(Integer id) {

Consultant got=consultantRepository.findById(id).orElse(null);
        if(got==null){
            return 0;
        }

        consultantRepository.save(got);

        return  1;
    }

private static ConsultantResponse convert(Consultant consultant){

        ConsultantResponse typeResponse=new ConsultantResponse();
typeResponse.setId(consultant.getId());
typeResponse.setName(consultant.getName());
typeResponse.setAdress(consultant.getAdress());
typeResponse.setTp(consultant.getTp());
typeResponse.setGender(consultant.getGender());
typeResponse.setNic(consultant.getNic());
typeResponse.setDob(consultant.getDob());
        typeResponse.setId(consultant.getId());

return typeResponse;
    }
}