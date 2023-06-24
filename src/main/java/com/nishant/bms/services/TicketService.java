package com.nishant.bms.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.nishant.bms.models.ShowSeat;
import com.nishant.bms.models.ShowSeatState;
import com.nishant.bms.models.Ticket;
import com.nishant.bms.models.TicketStatus;
import com.nishant.bms.repository.ShowRepository;
import com.nishant.bms.repository.ShowSeatRepository;
import com.nishant.bms.repository.TicketRepository;
import com.nishant.bms.repository.UserRepository;

@Service
public class TicketService {
   
	private TicketRepository ticketRepository;
	private ShowSeatRepository showSeatRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private ShowRepository showRepository;

	
	public TicketService(TicketRepository ticketRepository , ShowSeatRepository showSeatRepository)
	{
		this.ticketRepository = ticketRepository;
		this.showSeatRepository = showSeatRepository;
	}
	
    @Transactional(isolation = Isolation.SERIALIZABLE)
	public Ticket bookTicket(Long showId , List<Long> showSeatIds, Long userId) throws Exception
	{
		
		// fetch given showseats
		
		//List<ShowSeat> showSeats = showSeatIds.stream().map(id ->{ShowSeat showSeat = showSeatRepository.getReferenceById(id); return showSeat;}).collect(Collectors.toList());
    	List<ShowSeat> showSeats = showSeatRepository.findByIdIn(showSeatIds);
		//check if each of them are available
		for(ShowSeat showSeat : showSeats)
			if(!showSeat.getStats().equals(ShowSeatState.AVAILABLE))
				throw new Exception("Seat is not available");
		//update status to locked
		
		for(ShowSeat showSeat : showSeats)
		{
			showSeat.setStats(ShowSeatState.LOCKED);
			showSeatRepository.save(showSeat);
		}
		//return the ticket object
		
		Ticket ticket = new Ticket();
		ticket.setBookedBy(userRepository.findById(userId).get());
		ticket.setTicketStatus(TicketStatus.PENDING);
		ticket.setShow(showRepository.findById(showId).get());
		ticket.setTimeOfBooking(new Date());
		ticket.setShowSeats(showSeats);
		
		
		return ticketRepository.save(ticket);
	}
	
	
}
