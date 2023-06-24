package com.nishant.bms.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nishant.bms.exceptions.CityNotFoundException;
import com.nishant.bms.models.City;
import com.nishant.bms.repository.CityRepository;

@Service
public class CityService {
	
	
	private CityRepository cityRepository;
	public CityService(CityRepository cityRepository)
	{
		 this.cityRepository = cityRepository;
	}
	
	
	public City addCity(String name)
	{
		City city = new City();
		city.setName(name);
		City savedCity = cityRepository.save(city);
		return savedCity;
		
	}
	
//	public City findCity(Long id) throws CityNotFoundException
//	{
//		City city = cityRepository.getReferenceById(id);
//		if(city == null)
//			throw new CityNotFoundException("No city found");
//		
//		System.out.println(city);
//		
//		return city;
//	}

}
