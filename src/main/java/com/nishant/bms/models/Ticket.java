package com.nishant.bms.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public  class Ticket extends BaseModel{
	
	@ManyToOne
	private User bookedBy;
	
	@ManyToOne
	private Show show;
	
	
	// T : SS
	// 1 : M
	// M : 1
	
	// one showseat can be part of multiple tickets as we can cancel a ticket and that show
	// seat will be a part of another ticket
	
	// If cancellation not supportted then , 1 : M
	@ManyToMany(fetch = FetchType.EAGER)
	private List<ShowSeat> showSeats;
	private double totalAmount;
	
	@Enumerated(EnumType.STRING)
	private TicketStatus ticketStatus;
	private Date timeOfBooking;

}
