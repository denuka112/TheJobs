package com.seeker.service;


import com.seeker.entity.User;
import com.seeker.request.UserRequest;
import com.seeker.request.UserUpdateRequest;
import com.seeker.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserResponse save(UserRequest request);

    UserResponse update(UserUpdateRequest request);

    UserResponse getById(Integer id);

    List<UserResponse> getAll();
    UserResponse findByUsernameAndPassword(String un, String pw);

    Integer delete(Integer id);
}