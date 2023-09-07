package com.seeker.repository;


import com.seeker.entity.Jobapplyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

public interface JobapplyerRepository extends JpaRepository<Jobapplyer,Integer> , JpaSpecificationExecutor {


    List<Jobapplyer> findAll();


}