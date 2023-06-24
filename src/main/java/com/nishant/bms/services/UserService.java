package com.nishant.bms.services;

import org.springframework.stereotype.Service;

import com.nishant.bms.models.User;
import com.nishant.bms.repository.UserRepository;

@Service
public class UserService {
	
	
	private UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	public User createUser(String email)
	{
		User user = new User();
		user.setEmail(email);
		
		User savedUser = userRepository.save(user);
		return savedUser;
		
	}
	

}
