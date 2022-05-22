package com.capg.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Trainee {
	@Id
	private String traineeId;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "userID")
	private Users user;
	
	@NotBlank(message="712")
	private String name;
	
	@Transient
	private String trainerName;
	
	@NotBlank(message="713")
	private String technology;
	
	@OneToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="trainerId")
	//@NotBlank(message="714")
	private Trainer trainer;
	
	@NotBlank(message="715")
	private String location;
	
	@NotBlank(message="716")
	@Pattern(regexp="^[0-9]{3}-[0-9]{3}-[0-9]{4}$",message="556")
	private String contact;
	
	@NotBlank(message="717")
	private String domain;
	
	@Min(value=1,message="718")
	private int passOutYear;
	
	@NotBlank(message="719")
	private String education;
}
