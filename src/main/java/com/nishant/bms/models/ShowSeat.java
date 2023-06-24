package com.nishant.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class ShowSeat extends BaseModel{
	
	@ManyToOne
	private Show show;
	
	// SS : S
	// 1 : 1
	// M  :  1
	// Many : 1
	@ManyToOne
	private Seat seat;
	@Enumerated(EnumType.STRING)
	private ShowSeatState stats;

}
