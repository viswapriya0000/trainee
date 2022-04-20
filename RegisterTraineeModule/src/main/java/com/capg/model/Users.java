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
public class Users {
	@Id /*
		 * 
		 * 
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

	// @GeneratedValue(strategy=GenerationType.AUTO)
	// @NotNull
	private String userId;
	private String userName;
	private String password;
	//@OneToOne(mappedBy = "user")
	//@OneToOne
	//private Trainee trainee;
	// @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	// private List<Trainee> trainee;

	/*
	 * public String getUserId() { return userId; }
	 * 
	 * 
	 * 
	 * public Trainee getTrainee() { return trainee; } public void
	 * setTrainee(Trainee trainee) { this.trainee = trainee; }
	 * 
	 * 
	 * public List<Trainee> getTrainee() { return trainee; }
	 * 
	 * 
	 * public void setTrainee(List<Trainee> trainee) { this.trainee = trainee; }
	 * 
	 * 
	 * public void setUserId(String userId) { this.userId = userId; } public String
	 * getUserName() { return userName; } public void setUserName(String userName) {
	 * this.userName = userName; } public String getPassword() { return password; }
	 * public void setPassword(String password) { this.password = password; }
	 * 
	 * @Override public String toString() { return "User [userId=" + userId +
	 * ", userName=" + userName + ", password=" + password + "]"; }
	 * 
	 */

}
