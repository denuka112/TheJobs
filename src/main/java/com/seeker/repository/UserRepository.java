package com.seeker.repository;


import com.seeker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> , JpaSpecificationExecutor {


    List<User> findAll();
    User findByUsernameAndPassword(String un,String pw);



}