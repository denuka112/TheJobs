package com.seeker.entity;


import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="APPOINTMENT")
@Data
public class Appointment  {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(nullable=false)
private Integer id;

@Column(length=145)
private String jobapplyername;

@Column(length=145)
private String consultantname;

@Column(length=45)
private String applydate;

@Column(length=45)
private String applytime;

@Column(length=45)
private String status;

}