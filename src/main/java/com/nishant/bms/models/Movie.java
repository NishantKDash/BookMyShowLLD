package com.nishant.bms.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;

@Entity
public class Movie extends BaseModel{
 
	private String name;
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private List<Language> languages;
	@ManyToMany
	private List<Actor> actors;
	private int length;
	private double rating;
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private List<MovieFeature> movieFeatures;
	
	
}
