package com.nishant.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nishant.bms.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
