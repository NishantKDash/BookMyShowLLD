package com.nishant.bms;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nishant.bms.controllers.CityController;
import com.nishant.bms.controllers.TheatreController;
import com.nishant.bms.controllers.UserController;
import com.nishant.bms.dtos.CreateUserRequestDto;
import com.nishant.bms.models.SeatType;
import com.nishant.bms.services.CityService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	private UserController userController;
	@Autowired
	private CityController cityController;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private TheatreController theatreController;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
	
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		CreateUserRequestDto request = new CreateUserRequestDto();
		request.setEmail("nishantdash@gmail.com");
		userController.createUser(request);
		
		cityController.addCity("Chandigarh");
		this.theatreController.createTheatre("PVR", "ABC ROAD Chandigarh", 1L);
		
		this.theatreController.addAuditorium(1L, "AUDI 1", 100);
		
		HashMap<SeatType,Integer> map = new HashMap<>();
		map.put(SeatType.EXECUTIVE, 25);
		map.put(SeatType.PRIME, 50);
		map.put(SeatType.STANDARD, 25);
		
		
		
		
		theatreController.addSeats(1L, map);
	
		
		
		
		
		
		
	}

}
