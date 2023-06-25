package com.nishant.bms.controllers;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.nishant.bms.models.Language;
import com.nishant.bms.models.SeatType;
import com.nishant.bms.models.Show;
import com.nishant.bms.services.ShowService;

@Controller
public class ShowController {
	
	private ShowService showService;
	
	public ShowController (ShowService showService)
	{
		this.showService = showService;
	}
       
	
	public Show createShow(Long movieId , Date startTime , Date endTime , Long auditoriumId , Map<SeatType,Integer>seatPricing, Language language)
	{
		return showService.createShow(movieId, startTime, endTime, auditoriumId, seatPricing, language);
	}
}
