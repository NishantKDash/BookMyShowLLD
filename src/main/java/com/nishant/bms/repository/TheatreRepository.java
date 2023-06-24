package com.nishant.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nishant.bms.models.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Long>{


}
