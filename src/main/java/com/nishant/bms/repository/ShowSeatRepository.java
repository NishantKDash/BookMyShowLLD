package com.nishant.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.nishant.bms.models.ShowSeat;

import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long>{
   
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout" , value = "300000")})
	public List<ShowSeat> findByIdIn(List<Long> showSeatIds);
}
