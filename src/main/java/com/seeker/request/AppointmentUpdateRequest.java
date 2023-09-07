package com.seeker.request;



import lombok.Data;

@Data
public class AppointmentUpdateRequest {

private Integer id;

private String jobapplyername;

private String consultantname;

private String applydate;

private String applytime;

private String status;

 }