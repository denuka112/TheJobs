package com.seeker.repository;


import com.seeker.entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

public interface ConsultantRepository extends JpaRepository<Consultant,Integer> , JpaSpecificationExecutor {


    List<Consultant> findAll();


}