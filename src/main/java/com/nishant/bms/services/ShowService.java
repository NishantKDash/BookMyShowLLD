package com.nishant.bms.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant.bms.models.Auditorium;
import com.nishant.bms.models.Language;
import com.nishant.bms.models.Seat;
import com.nishant.bms.models.SeatType;
import com.nishant.bms.models.Show;
import com.nishant.bms.models.ShowSeat;
import com.nishant.bms.models.ShowSeatState;
import com.nishant.bms.repository.AuditoriumRepository;
import com.nishant.bms.repository.ShowRepository;
import com.nishant.bms.repository.ShowSeatRepository;

@Service
public class ShowService {
	
	@Autowired
	private AuditoriumRepository auditoriumRepository;
	
	@Autowired
	private ShowRepository showRepository;
   
	
	@Autowired
	private ShowSeatRepository showSeatRepository;
	public Show createShow(Long movieId , Date startTime , Date endTime , Long auditoriumId , Map<SeatType,Integer> seatPricing , Language language)
	{
		Show show = new Show();
		show.setStartTime(startTime);
		show.setEndTime(endTime);
		show.setLanguage(language);
		Auditorium auditorium = auditoriumRepository.findById(auditoriumId).get();
		show.setAuditorium(auditorium);
		
		
		Show savedShow = showRepository.save(show);
		List<ShowSeat> showSeats = new ArrayList<>();
		
		for(Seat seat : auditorium.getSeats())
		{
			ShowSeat showSeat = new ShowSeat();
			showSeat.setShow(savedShow);
			showSeat.setSeat(seat);
			showSeat.setStats(ShowSeatState.AVAILABLE);
			showSeatRepository.save(showSeat);
			showSeats.add(showSeat);
			
		}
		
		savedShow.setShowSeats(showSeats);
		showRepository.save(savedShow);
		return show;
	}
}
