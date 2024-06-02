package com.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manager.dao.UserRepo;
import com.manager.entities.Student;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepo userrep;
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		
		Student st = new Student();
		st.setName("Rajib Shah");
		st.setCourse("java programming ");
		st.setEmail("rajib@gmail.com");
		st.setGrades("A");
		st.setEnrolled(true);
		st.setPayment("Fifteen thousand");
		
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
		
		model.addAttribute("title", "Signup of student manager");
		return "signup";
	}
	@RequestMapping("/base")
	public String base(Model model) {
		
		model.addAttribute("title", "BASE PAGE");
		return "base";
	}// thymeleaf -> templating engine

}

