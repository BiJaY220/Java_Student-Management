package com.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manager.entities.Student;

public interface UserRepo extends JpaRepository<Student, Integer> {
	
	@Query("select u from User u where u.email = :email")
	public Student getStudentByUserName(@Param("email") String email);

}
