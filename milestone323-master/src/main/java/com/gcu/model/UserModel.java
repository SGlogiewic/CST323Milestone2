package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel {

	private int id;
	
	@NotNull(message="First Name is required.")
	@Size(min=1, max=25, message="First name must be between 1 to 25 characters.")
	private String firstName;
	
	@NotNull(message="Last Name is required.")
	@Size(min=1, max=30, message="Last name must be between 1 to 30 characters.")
	private String lastName;
	
	@NotNull(message="Email is required.")
	@Size(min=7,max=45, message="Email must be between 7 to 45 characters.")
	private String email;
	
	@NotNull(message="Phone is required.")
	@Size(min=1,max=10, message="Phone number cannot exceed 10 digits.")
	private String phone;
	
	@NotNull(message="Username is required.")
	@Size(min=1, max=45, message="Username must be between 1 to 45 characters.")
	private String username;
	
	@NotNull(message="Password is required.")
	@Size(min=8, max=45, message="Password must be between 8 to 45 characters.")
	private String password;
	
	public UserModel() {
		
	}

	public UserModel(int id, String firstName, String lastName, String email, String phone, String username,
			String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
