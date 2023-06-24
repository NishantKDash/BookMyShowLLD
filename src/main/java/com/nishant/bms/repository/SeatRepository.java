package com.nishant.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nishant.bms.models.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat , Long>{

}
