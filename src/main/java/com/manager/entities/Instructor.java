package com.manager.entities;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name ="INSTRUCTOR")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@NotBlank(message="Name field is required !!")
	@Size(min=2,max=20,message="Min 2 and max 20 characters are allowed !!")
	private String iname;
	private String course;
	@Column(unique = true)
	private String email;
	private String password;
	
	private String role;
	private String imageurl;
	// for courses

	private int price;
	private String timeduration;
	private String cimageurl;
	private String progresscourse;
	@Column(length = 500)
	private String aboutcourse;
	// student
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "stu")
    private List<Student> stu = new ArrayList<>();

}
