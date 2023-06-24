package com.nishant.bms.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
public class Auditorium extends BaseModel{
	
	
	private String name;
	@OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	private List<Seat> seats;
	private int capacity;
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private List<AuditoriumFeature> auditoriumFeatures;
	@ManyToOne
	private Theatre theatre;

}
