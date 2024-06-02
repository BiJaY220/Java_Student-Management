package com.manager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="COURSE")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cId;
	private String name;
	private int price;
	private String timeduration;
	private String imageurl;
	private String progress;
	private String instructor;
	@Column(length = 500)
	private String description;
	
	
	@ManyToOne
	private Student stu;
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTimeduration() {
		return timeduration;
	}
	public void setTimeduration(String timeduration) {
		this.timeduration = timeduration;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Course(int cId, String name, int price, String timeduration, String imageurl, String progress,
			String instructor, String description) {
		super();
		this.cId = cId;
		this.name = name;
		this.price = price;
		this.timeduration = timeduration;
		this.imageurl = imageurl;
		this.progress = progress;
		this.instructor = instructor;
		this.description = description;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

}

