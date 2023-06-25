package com.nishant.bms.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.nishant.bms.models.Ticket;
import com.nishant.bms.services.TicketService;


@Controller
public class TicketController {
	
	
	private TicketService ticketService;
	
	
	public TicketController(TicketService ticketService)
	{
		this.ticketService = ticketService;
	}
	
	public Ticket bookTicket(Long showId , List<Long> showSeatIds , Long userId) throws Exception
	{
		 return ticketService.bookTicket(showId, showSeatIds, userId);
	}

}
