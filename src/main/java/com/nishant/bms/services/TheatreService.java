package com.nishant.bms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant.bms.exceptions.CityNotFoundException;
import com.nishant.bms.models.Auditorium;
import com.nishant.bms.models.City;
import com.nishant.bms.models.Seat;
import com.nishant.bms.models.SeatType;
import com.nishant.bms.models.Theatre;
import com.nishant.bms.repository.AuditoriumRepository;
import com.nishant.bms.repository.CityRepository;
import com.nishant.bms.repository.TheatreRepository;

@Service
public class TheatreService {
	
	private TheatreRepository theatreRepository;
	private CityRepository cityRepository;
	@Autowired
	private AuditoriumRepository auditoriumRepository;
	
	public TheatreService(TheatreRepository theatreRepository , CityRepository cityRepository)
	{
		this.cityRepository = cityRepository;
		this.theatreRepository = theatreRepository;
	}
	
	
	public Theatre createTheatre(String name , String address , Long cityId) throws CityNotFoundException
	{
		//Create a theatre object 
		// fetch the city for the id
		// add the theatre to the city
		// update the city in db
		// save the theatre
		
		Theatre theatre = new Theatre();
		theatre.setName(name);
		theatre.setAddress(address);
		Theatre savedTheatre = theatreRepository.save(theatre);
		
		Optional<City> cityOptional= cityRepository.findById(cityId);
		
		if(!cityOptional.isPresent())
		{
			throw new CityNotFoundException("No city with given ID");
		}
		
		City dbcity = cityOptional.get();
		dbcity.getTheatres().add(savedTheatre);
		cityRepository.save(dbcity);
		return savedTheatre;
	    
		
	}
	
	public Theatre addAuditorium(Long theatreId , String name , int capacity)
	{
		Theatre theatre = theatreRepository.findById(theatreId).get();
		
		Auditorium auditorium = new Auditorium();
		auditorium.setCapacity(capacity);
		auditorium.setName(name);
		auditorium.setTheatre(theatre);
		theatre.getAuditoriums().add(auditorium);
		return theatreRepository.save(theatre);
	}

	
	public void addSeats(Long auditoriumId , Map<SeatType,Integer> seatCount)
	{
		Auditorium auditorium = auditoriumRepository.findById(auditoriumId).get();
		//Theatre theatre = theatreRepository.findById(theatreId).get();
		List<Seat> seats = new ArrayList<>();
		
		for(SeatType seatType : seatCount.keySet())
		{
			int count = seatCount.get(seatType);
			for(int i = 0;i<count;i++)
			{
				seats.add(new Seat(seatType.toString() + Integer.toString(i+1), seatType));
			}
		}
		
		auditorium.setSeats(seats);
		auditoriumRepository.save(auditorium);
		
		
		
	}
}
