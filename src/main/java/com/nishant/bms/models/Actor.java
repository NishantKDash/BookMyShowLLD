package com.nishant.bms.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;


@Entity
public class Actor extends BaseModel{
   
	private String name;
	@ManyToMany(mappedBy = "actors")
	private List<Movie> movies;
}
