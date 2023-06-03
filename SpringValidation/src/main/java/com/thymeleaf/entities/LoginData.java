package com.thymeleaf.entities;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginData {
	
	@NotBlank(message = "Username must be fill up")
	@Size(min = 7,max = 18, message = "user name length must be between 7 to 18 characters")
   private String user;
	
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "invalid Email")
   private String email;
	
	@AssertTrue(message = "please agree the conditions")
	private boolean agreed;
	
public boolean isAgreed() {
		return agreed;
	}
	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "LoginData [user=" + user + ", email=" + email + "]";
}
}
