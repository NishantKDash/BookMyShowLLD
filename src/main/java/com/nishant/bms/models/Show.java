package com.nishant.bms.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Show extends BaseModel{
	
	
	@ManyToOne
	private Movie movie;
	private Date startTime;
	private Date endTime;
	@ManyToOne
	private Auditorium auditorium;
	
	@OneToMany(mappedBy = "show")
	private List<ShowSeat> showSeats;
	
    @OneToMany(mappedBy = "show")
	private List<ShowSeatType> showSeatTypes;
    @Enumerated(EnumType.STRING)
    private Language language;
    
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<ShowFeature> showFeatures;

}
