package com.manager.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manager.entities.Course;
import com.manager.entities.Instructor;
import com.manager.entities.Student;


public interface CourseRepo extends JpaRepository<Course, Integer> {

	//for the pagination
	@Query("from Course as c where c.student.id =:studentId")
	public Page<Course> findCourseByStudents(@Param("studentId") int studentId,Pageable pePageable);
	
	//searching a name and stuedent
	public List<Course> findByNameContainingAndStudent(String name,Instructor ins);
}