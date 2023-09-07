package com.seeker.service.impl;


import com.seeker.request.UserRequest;
import com.seeker.request.UserUpdateRequest;
import com.seeker.response.UserResponse;
import com.seeker.entity.User;
import com.seeker.repository.UserRepository;
import com.seeker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
@Transactional
    public UserResponse save(UserRequest request) {

        User user=new User();
user.setUsername(request.getUsername());
user.setPassword(request.getPassword());
user.setType(request.getType());

User save=userRepository.save(user);

        return convert(save);
    }

    @Override
    @Transactional
    public UserResponse update(UserUpdateRequest request) {

User user = userRepository.findById(request.getId()).orElse(null);
        if(user==null){
            return null;
        }

user.setId(request.getId());
user.setId(request.getId());
user.setUsername(request.getUsername());
user.setPassword(request.getPassword());
user.setType(request.getType());
User updated=userRepository.save(user);

        return (convert(updated));
    }

    @Override
    public UserResponse getById(Integer id) {

       return userRepository.findById(id).map(UserServiceImpl::convert).orElse(null);
    }


    @Override
    public UserResponse findByUsernameAndPassword(String un,String pw) {

        User pe = userRepository.findByUsernameAndPassword(un, pw);

        UserResponse ress = new UserResponse();
        ress.setId(pe.getId());

        ress.setUsername(pe.getUsername());
        ress.setPassword(pe.getPassword());
        ress.setType(pe.getType());


        return ress;    }

    @Override
    public List<UserResponse> getAll() {

        return  userRepository.findAll()
                .stream().map(UserServiceImpl::convert).collect(Collectors.toList());

    }


    @Override
    @Transactional
    public Integer delete(Integer id) {

User got=userRepository.findById(id).orElse(null);
        if(got==null){
            return 0;
        }

        userRepository.save(got);

        return  1;
    }

private static UserResponse convert(User user){

        UserResponse typeResponse=new UserResponse();
typeResponse.setId(user.getId());
typeResponse.setUsername(user.getUsername());
typeResponse.setPassword(user.getPassword());
typeResponse.setType(user.getType());
        typeResponse.setId(user.getId());

return typeResponse;
    }
}