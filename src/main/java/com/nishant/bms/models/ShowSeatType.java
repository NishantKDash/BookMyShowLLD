package com.nishant.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;


/*
 * For a show , for eavery seat type , what is the price for those
 * seat types for that show.*/
@Entity
public class ShowSeatType extends BaseModel{
	
	
	// SST : S
	// 1 : 1
	// M : 1
	@ManyToOne
	private Show show;
	@Enumerated(EnumType.STRING)
	private SeatType seatType;
	private double price;

}
