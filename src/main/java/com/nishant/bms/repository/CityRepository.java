package com.nishant.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nishant.bms.models.City;

@Repository
public interface CityRepository extends JpaRepository<City , Long>{

}
