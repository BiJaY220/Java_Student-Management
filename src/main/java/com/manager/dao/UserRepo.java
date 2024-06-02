package com.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.entities.Student;

public interface UserRepo extends JpaRepository<Student, Integer> {
	
	

}
