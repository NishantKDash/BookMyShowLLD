package com.nishant.bms.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;

import com.nishant.bms.exceptions.CityNotFoundException;
import com.nishant.bms.models.SeatType;
import com.nishant.bms.models.Theatre;
import com.nishant.bms.services.TheatreService;

@Controller
public class TheatreController {
	private TheatreService theatreService;
	public TheatreController(TheatreService theatreService)
	{
		this.theatreService = theatreService;
	}

	
	public Theatre createTheatre(String name , String address , Long cityId) throws CityNotFoundException
	{
	  return theatreService.createTheatre(name, address, cityId);
	}
	
	
	public Theatre addAuditorium(Long theatreId , String name , int capacity)
	{
		
		return theatreService.addAuditorium(theatreId, name, capacity);
	}
	
	
	public void addSeats(Long auditoriumId , Map<SeatType,Integer> seatCount)
	{
		 theatreService.addSeats(auditoriumId, seatCount);
	}

}
