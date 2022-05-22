package com.capg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Component
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
 
public @Data class Users {

	@Id
	private String userID;
	
	@Column(unique=true)
	@NotBlank(message="709")
	@Pattern(regexp="^[a-zA-Z0-9]{3,}$",message="554")  
	private String userName;
	
	@NotBlank(message="710")
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",message="555")
	private String password;
	
	@NotBlank(message="711")
	@Transient
	private String confirmPassword;

	


}
