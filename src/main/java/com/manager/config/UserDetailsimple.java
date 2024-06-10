package com.manager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.manager.dao.*;
import com.manager.entities.*;

public class UserDetailsimple implements UserDetailsService
{

	@Autowired
	private UserRepo userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//fetch student from database
		 Student student=userRepository.getStudentByUserName(username);
		if(student==null)
		{
			throw new UsernameNotFoundException("student could not be found !!");
		}
		OurDetails ourDetails=new OurDetails(student);
		
		return ourDetails;
	}

}