package com.nishant.bms.controllers;

import org.springframework.stereotype.Controller;

import com.nishant.bms.models.City;
import com.nishant.bms.services.CityService;

@Controller
public class CityController {
	 private CityService cityService;
	
	public CityController(CityService cityService)
	{
		this.cityService = cityService;
	}
	
	public City addCity(String name)
	{
		return this.cityService.addCity(name);
	}

}
