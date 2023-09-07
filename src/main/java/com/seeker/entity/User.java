package com.seeker.entity;


import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="USER")
@Data
public class User  {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(nullable=false)
private Integer id;

@Column(length=145)
private String username;

@Column(length=45)
private String password ;

@Column(length=45)
private String type;

}