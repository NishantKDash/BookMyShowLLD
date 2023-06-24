package com.nishant.bms.controllers;

import org.springframework.stereotype.Controller;

import com.nishant.bms.dtos.CreateUserRequestDto;
import com.nishant.bms.dtos.CreateUserResponseDto;
import com.nishant.bms.models.User;
import com.nishant.bms.services.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	
	
	public UserController(UserService userService)
	{
		this.userService = userService;
	}
     
	public CreateUserResponseDto createUser(CreateUserRequestDto userDto)
	{
	    User savedUser = userService.createUser(userDto.getEmail());
	    CreateUserResponseDto response = new CreateUserResponseDto();
	    response.setUser(savedUser);
	    return response;
	}
}
