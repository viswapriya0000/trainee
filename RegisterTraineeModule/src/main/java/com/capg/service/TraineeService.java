package com.capg.service;

import java.util.List;
import java.util.Optional;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.capg.exceptionhandler.ResourceNotFoundException;
import com.capg.model.Trainee;
import com.capg.model.Trainer;
import com.capg.model.Users;
import com.capg.repository.TraineeRepo;
import com.capg.repository.UserRep;

@Service
@Transactional
public class TraineeService {
	

	@Autowired
	TraineeRepo traineeRepo;

	@Autowired
	UserRep userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	List<Trainee> trainee;

	public List<Trainee> getAllTrainees() {
		return traineeRepo.findAll();
	}

	public Trainee addTrainee(Trainee trainee) {
		trainee = generateUserId(trainee);
		trainee = setTrainer(trainee);
		return traineeRepo.save(trainee);
	}

	private Trainee setTrainer(Trainee trainee) {
		Trainer trainer = restTemplate.getForObject("http://TRAINER-MICROSERVICE/Trainer/getTrainerObj/"+trainee.getTrainerName(), Trainer.class );
		trainee.setTrainer(trainer);
		return trainee;
	}

	private Trainee generateUserId(Trainee trainee) {
		Users user = trainee.getUser();
		user.setUserID("TNE-" + trainee.getTechnology().substring(0, 3) + "-" + (traineeRepo.count() + 1));
		trainee.setUser(user);
		return trainee;
	}
	
	public Optional<Trainee>  getTraineeById(String id) {
		try {
			return Optional.of(traineeRepo.findByTraineeId(id));
		}
		catch(Exception e) {
			throw new ResourceNotFoundException("NO SUCH ID");
		}
	}
	
	public Optional<Trainee> getTraineeByName(String name) {
		try {
		return Optional.of(traineeRepo.findByName(name));
		}
		catch(Exception e) {
			throw new ResourceNotFoundException("NO SUCH NAME");
		}
	}
	
	public Trainee addTraineeDetails(Trainee trainee) {
		trainee = generateUserId(trainee);
		return traineeRepo.save(trainee);
	}

	
	
}
