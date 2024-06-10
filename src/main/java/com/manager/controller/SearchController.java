package com.manager.controller;

import com.manager.dao.StudentRepo;
import com.manager.dao.UserRepo;
import com.manager.entities.Instructor;
import com.manager.entities.Student;

import java.security.Principal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
public class SearchController {
	@Autowired
	private UserRepo userRepository;
	@Autowired
	private StudentRepo courseRepository;

	//search Handler
	@GetMapping("/search/{query}")
	public ResponseEntity<?> search(@PathVariable("query") String query,Principal principal)
	{
		
		System.out.println(query);
		Instructor instructor=this.userRepository.getInstructorByUserName(principal.getName());
		
		List<Instructor> instructors=this.courseRepository.findByNameContainingAndInstructors(query, instructor);
		return ResponseEntity.ok(instructor);
		
	}

}
