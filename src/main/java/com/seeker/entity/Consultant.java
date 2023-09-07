package com.seeker.entity;


import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="CONSULTANT")
@Data
public class Consultant  {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(nullable=false)
private Integer id;

@Column(length=145)
private String name;

@Column(length=145)
private String adress;

@Column(length=45)
private String tp;

@Column(length=45)
private String gender;

@Column(length=45)
private String nic;

@Column(length=45)
private String dob;

}