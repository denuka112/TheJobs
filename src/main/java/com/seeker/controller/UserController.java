package com.seeker.controller;


import com.seeker.request.UserRequest;
import com.seeker.request.UserUpdateRequest;
import com.seeker.response.UserResponse;
import com.seeker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("User")
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<UserResponse> save(@Valid @RequestBody UserRequest request){
        UserResponse save = userService.save(request);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<UserResponse> update(@Valid @RequestBody UserUpdateRequest request){
        UserResponse updated = userService.update(request);
        if(updated==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }


    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable("id") @NotBlank Integer id){
        UserResponse get = userService.getById(id);
System.out.println(get.getPassword());
        if(get==null){

            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(get);
    }

    @GetMapping("logcheck/{uname}/{password}")
    public ResponseEntity<UserResponse> getByunpw(@PathVariable("uname") @NotBlank String uname, @PathVariable("password") @NotBlank String password) {
        UserResponse get = userService.findByUsernameAndPassword(uname, password);

        if (get == null) {

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(get);
    }




    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAll(){
        List<UserResponse> getall = userService.getAll();
        return ResponseEntity.ok(getall);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") @NotBlank Integer id){
        int deleted = userService.delete(id);
        if(deleted==0){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
}