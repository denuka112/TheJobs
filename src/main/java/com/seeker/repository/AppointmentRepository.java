package com.seeker.repository;


import com.seeker.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> , JpaSpecificationExecutor {


    List<Appointment> findAll();


}