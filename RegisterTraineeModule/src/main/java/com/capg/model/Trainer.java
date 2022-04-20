package com.capg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Trainer {
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
	private String userId;
	//@OneToOne
	//@OneToOne(mappedBy="trainer")
	//@OneToMany(mappedBy="trainer",cascade=CascadeType.ALL)
	//private Trainee trainee;

	

	

	
}
