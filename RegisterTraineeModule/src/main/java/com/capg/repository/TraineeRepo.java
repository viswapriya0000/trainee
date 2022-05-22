package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capg.model.Trainee;
@Repository
public interface TraineeRepo extends JpaRepository<Trainee,String> {
	
	Trainee findByTraineeId(String id);
	Trainee findByName(String name);

}
