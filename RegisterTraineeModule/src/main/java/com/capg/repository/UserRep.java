package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.model.Users;
@Repository
public interface UserRep extends JpaRepository<Users,String>{

}
