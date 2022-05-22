package com.capg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.model.Trainee;
import com.capg.model.Trainer;
import com.capg.model.Users;
import com.capg.repository.TraineeRepo;
import com.capg.service.TraineeService;

@SpringBootTest
public class TraineeTest {
	@Autowired
	TraineeService service;
	@MockBean
	TraineeRepo repository;
	
	
	@Test
	public void getAllTrainee(){
		Trainer trainer1=new Trainer("TNR-mic-1",new Users("TNR-mic-1","madhu123","Madhuu@123","Madhu@123"),"madhu","microservices","HYD","456456123","madhu@gmaail.com");
		Users user1=new Users("TNE-mic-1","priya123","Priya@123","Priya@123");
		Trainee trainee1=new Trainee("TNE-mic-1",user1,"priya","madhu","microservices",trainer1,"HYD","123-456-7890","GCP",2022,"B.TECH");
		Trainer trainer2=new Trainer("TNR-jav-2",new Users("TNR-jav-2","vasu123","Vasu@123","Vasu@123"),"vasu","java","BNG","456456145","vasu@gmaail.com");
		Users user2=new Users("TNE-jav-2","vidi123","Vidhi@123","Vidhi@123");
		Trainee trainee2=new Trainee("TNE-jav-2",user2,"vidi","vasu","java",trainer2,"BNG","456-789-1230","GCP",2022,"B.TECH");
		  when(repository.findAll()).thenReturn(Stream.of(trainee1,trainee2).collect(Collectors.toList()));				  
		  assertEquals(2,service.getAllTrainees().size());
	  }
	
	@Test
	public void getTraineeById() {
		Trainer trainer=new Trainer("TNR-mic-1",new Users("TNR-mic-1","madhu123","Madhuu@123","Madhu@123"),"madhu","microservices","HYD","456456123","madhu@gmaail.com");
		Users user=new Users("TNE-mic-1","priya123","Priya@123","Priya@123");
		Trainee trainee=new Trainee("TNE-mic-1",user,"priya","madhu","microservices",trainer,"HYD","123-456-7890","GCP",2022,"B.TECH");
		String id="TNE-mic-1";
		when(repository.findByTraineeId(id)).thenReturn(trainee);
		assertEquals(trainee,service.getTraineeById(id).get());
	}
	
	@Test
	public void getTraineeByName() {
		String name="priya";
		Trainer trainer=new Trainer("TNR-mic-1",new Users("TNR-mic-1","madhu123","Madhuu@123","Madhu@123"),"madhu","microservices","HYD","456456123","madhu@gmaail.com");
		Users user=new Users("TNE-mic-1","priya123","Priya@123","Priya@123");
		Trainee trainee=new Trainee("TNE-mic-1",user,"priya","madhu","microservices",trainer,"HYD","123-456-7890","GCP",2022,"B.TECH");
		when(repository.findByName(name)).thenReturn(trainee);
		assertEquals(trainee,service.getTraineeByName(name).get());
	}
	
	@Test
	public void registerTrainee() {
		Trainee trainee=new Trainee();
		Users user=new Users();
	    user.setUserID("TNE-mic-1");
	    user.setUserName("priya123");
	    user.setPassword("Priya@123");
	    Trainer trainer=new Trainer("TNR-mic-1",new Users("TNR-mic-1","madhu123123","Madhu@123","Madhu@123"),"madhu","microservices","HYD","456456123","madhu@gmaail.com");
		trainee.setContact("789-456-1230");
		trainee.setDomain("GCP");
		trainee.setEducation("B.TECH");
		trainee.setLocation("HYD");
		trainee.setName("priya");
		trainee.setPassOutYear(2022);
		trainee.setTechnology("microservices");
		trainee.setTrainer(trainer);
		trainee.setTrainerName("madhu");
		trainee.setUser(user);
		trainee.setTraineeId("TNE-mic-1");
		when(repository.save(trainee)).thenReturn(trainee);
		assertEquals(trainee,service.addTraineeDetails(trainee));
		
	}


}
