package com.manager.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manager.dao.StudentRepo;
import com.manager.dao.UserRepo;
import com.manager.entities.Instructor;
import com.manager.entities.Student;



@Controller
@RequestMapping("/instructor")
public class InstructorController {
	
	@Autowired
	public StudentRepo studentRepo;
	@Autowired
	public UserRepo userRepo;
	// to add a data 
	
	
	@ModelAttribute
	public void addcommonStuData(Model model, Principal principal) {
		String userNameString = principal.getName();
		System.out.println("the username or stunamed "+userNameString);
		
		Instructor instructor = userRepo.getInstructorByUserName(userNameString);
		System.out.println("Instructor:"+instructor);
		model.addAttribute("instructor" ,instructor);
		
		
	}
	
	@GetMapping("/add-student")
	public String NewStudentForm(Model model) {
		model.addAttribute("title", "New Student");
		model.addAttribute("student", new Student());
		
		return "about/add_student_form";
	}
	
	@RequestMapping("/home")
	public String Opendashboard(Model model, Principal principal) {
		model.addAttribute("title","Instructor Dashboard");
		
		return "home/instructor_dashboard";
		
		
	}
	@RequestMapping("/{id}/student")
	public String showStudentDetails(@PathVariable("id") Integer id,Model model,
			Principal principal)
	{
		Optional<Student> studentOptional = this.studentRepo.findById(id);
		Student student = studentOptional.get();
		 String nameString = principal.getName();
		 Instructor instructor = this.userRepo.getInstructorByUserName(nameString);
		 if(instructor.getId() == student.getIns().getId()) {
			 model.addAttribute("student" , student);
			 model.addAttribute("title ", student.getName());
			 }
	return "/home/student_detail";
	}
	@RequestMapping("/show-students/{page}")
	public String showStudents(@PathVariable("page") Integer page,Model model,
			Principal principal)
	{
		model.addAttribute("title", "all details of Student");
		String nameString = principal.getName();
		Instructor instructor = this.userRepo.getInstructorByUserName(nameString);
		// pages of Students
		Pageable pageable = PageRequest.of(page, 3);
		
		Page<Student> studentsPage = this.studentRepo.findStudentByInstructor(instructor.getId(),pageable);
		model.addAttribute("students", studentsPage);
		model.addAttribute("initial page", page);
		model.addAttribute("total pages", studentsPage.getTotalPages());
		
		
		
		
	return "/home/show_students";
	}
	
	
	@RequestMapping("/{id}/student")
	public String deleteStudent(@PathVariable("id") Integer id, Model model ,
			Principal principal) {
		
		
		return "/home/delete_page";
	}
	

}
