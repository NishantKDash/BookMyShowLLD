package com.nishant.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nishant.bms.models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long>{

}
