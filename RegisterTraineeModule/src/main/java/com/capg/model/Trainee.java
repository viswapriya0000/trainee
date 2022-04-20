package com.capg.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainee {
	//@Id
	@NotNull
	//private String userId;
	//private int traineeId;
	@OneToOne(cascade=CascadeType.ALL)
	//@ManyToOne
	@JoinColumn(name="userId")
	//@JoinColumn(name="trainerId")
	//@JoinColumn(name="userIdfk",referencedColumnName="userId")
	private Users user;
	@Id
	/*
	 * @GeneratedValue(generator="system-uuid")
	 * 
	 * @GenericGenerator(name="system-uuid", strategy = "uuid")
	 */
	/*
	 * @SequenceGenerator( name = "student_sequence", sequenceName =
	 * "student_sequence", allocationSize = 1 )
	 * 
	 * @GeneratedValue( generator = "student_sequence", strategy =
	 * GenerationType.SEQUENCE )
	 */
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@NotBlank
	private String Name;
	
	
	
	//@ManyToOne
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="trainerId")
	private Trainer trainer;
	@NotBlank
	private String location;
	//@Pattern(regexp="")
	@NotBlank
	private String contact;
	@NotBlank
	private String technology;
	@NotBlank
	private String domain;
	@NotNull
	private int passOutYear;
	@NotBlank
	private String education;
	
	
	
}
