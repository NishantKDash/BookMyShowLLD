package com.nishant.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nishant.bms.models.Auditorium;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium,Long>{

}
