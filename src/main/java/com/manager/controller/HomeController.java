package com.manager.controller;

import java.net.http.HttpClient;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manager.dao.UserRepo;
import com.manager.entities.Course;
import com.manager.entities.Student;
import com.manager.utility.Messages;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepo userrep;
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		
		/*
		 * Student st = new Student(); st.setName("Rajib Shah");
		 * st.setCourse("java programming "); st.setEmail("rajib@gmail.com");
		 * st.setGrades("A"); st.setEnrolled(true); st.setPayment("Fifteen thousand");
		 * Course crCourse = new Course(); st.getCourse().add(crCourse);
		 * userrep.save(st);
		 */
		
		return "try";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		
		model.addAttribute("title", "About-student manager");
		return "about";
		
		
	}
	@RequestMapping("/home")
	public String home(Model model) {
		
		model.addAttribute("title", "Homepage of student manager");
		return "home";
		}
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Register - Smart Contact Manger");
		model.addAttribute("student", new Student());
		return "signup";
	}
	@PostMapping(value="/signup")
	public String signup(@ModelAttribute("student") Student student,
			@RequestParam(value = "agreement", defaultValue = "false") boolean aggreement,Model model,HttpSession session) {
		
		try {
			if (!aggreement) {
				
				throw new Exception("the checkbox is not marked!!");
			}
			System.out.println("aggreed "+aggreement);
			System.out.println("Student :"+student);
			Student rStudent = this.userrep.save(student);
			
			
			model.addAttribute("student", new Student());
			//message
			

			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("student", student);
			session.setAttribute("message", new Messages("kei galat vayo"+e.getMessage(),"alert-danger"));
			
			
		}
		return "signup";
	}
	
	@RequestMapping("/base")
	public String base(Model model) {
		
		model.addAttribute("title", "BASE PAGE");
		return "base";
	}// thymeleaf -> templating engine
	
	
	
	
	@GetMapping("/signin")
	public String customLogin(Model model)
	{
		model.addAttribute("title","Login Page");
		return "login.html";
	}

}

