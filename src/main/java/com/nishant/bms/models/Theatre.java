package com.nishant.bms.models;

import java.util.List;

//import org.hibernate.annotations.CascadeType;
import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Theatre extends BaseModel{
	
	private String name;
	private String address;
	
	@OneToMany(mappedBy = "theatre" , cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	private List<Auditorium> auditoriums;
	
	@OneToMany
	private List<Show> upcomingShows;

}
