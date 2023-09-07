package com.seeker.entity;


import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="JOBAPPLYER")
@Data
public class Jobapplyer  {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(nullable=false)
private Integer id;

@Column(length=245)
private String name;

@Column(length=245)
private String address;

@Column(length=45)
private String nic;

@Column(length=45)
private String gender;

@Column(length=45)
private String dob;

@Column(length=45)
private String school;

}