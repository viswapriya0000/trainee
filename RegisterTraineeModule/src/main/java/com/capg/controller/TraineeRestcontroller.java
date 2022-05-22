package com.capg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.Trainee;
import com.capg.service.TraineeService;

@RestController
@RequestMapping("/Trainee")
public class TraineeRestcontroller {
	@Autowired
	TraineeService traineeService;
	
	@GetMapping("/fetchTraineeDetails")
	public ResponseEntity<List<Trainee>> fetchAllTrainee(){
		  List<Trainee> traineeObj=traineeService.getAllTrainees();
		  return new ResponseEntity<List<Trainee>>(traineeObj,HttpStatus.OK);
	  }
	
	
	@PostMapping("/insertTraineeDetails")
	public ResponseEntity<Trainee> addTraineeDetails(@Validated @RequestBody Trainee trainee) {
			Trainee traineeResponse =traineeService.addTrainee(trainee);
			  return new ResponseEntity<Trainee>(traineeResponse,HttpStatus.OK);
		  }
	
	@GetMapping("/getTraineeById/{id}")
	public ResponseEntity<Trainee> getTraineeById(@PathVariable("id") String id){
		Optional<Trainee> trainee = traineeService.getTraineeById(id);
		return new ResponseEntity<Trainee> (trainee.get(), HttpStatus.OK);
	}
	
	@GetMapping("/getTraineeByName/{name}")
	public ResponseEntity<Trainee> getTraineeByName(@PathVariable("name") String name){
		Optional<Trainee> trainee = traineeService.getTraineeByName(name);
		return new ResponseEntity<Trainee> (trainee.get(), HttpStatus.OK);
	}
	
	

}
