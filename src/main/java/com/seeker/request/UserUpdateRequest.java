package com.seeker.request;



import lombok.Data;

@Data
public class UserUpdateRequest {

private Integer id;

private String username;

private String password;

private String type;

 }