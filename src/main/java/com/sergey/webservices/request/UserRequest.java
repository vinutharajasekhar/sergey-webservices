package com.sergey.webservices.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

public class UserRequest {

	@NotNull(message = "First Name cannot be null")
	private String firstName;
	@NotNull(message = "Last name cannot be null")
	private String lastName;
	@NotNull(message = "Email cannot be null")
	@Email
	private String email;
	@NotNull(message = "Password cannot be null")
	@Size(min = 8, max = 16, message = "password must be equal or greater 8 characters and less than 16 characters")
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
