package com.cts.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Manager {

	@Size(min = 3, max = 15, message = "Min 3,Max 15 alphabets needed")
	private String firstName;
	@Size(min = 3, max = 15, message = "Min 3,Max 15 alphabets needed")
	private String lastName;
	@Pattern(regexp="(^$|[0-9]{10})",message="Invalid Contact Number")
	private String contactNo;
	@Email(message = "Invalid Email Id")
	private String email;
	@Pattern(regexp ="^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"
			+ "(?=\\S+$).{8,20}$", message = "Password Criteria Not Met")
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	private String[] skills;

	public Manager(@Size(min = 3, max = 15, message = "Min 3,Max 15 alphabets needed") String firstName,
			@Size(min = 3, max = 15, message = "Min 3,Max 15 alphabets needed") String lastName,
			@Size(min = 10, max = 10, message = "Ph No should be of size 10") String contactNo,
			@Pattern(regexp = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$", message = "Invalid email") String email,
			@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\]).{6,20}$", message = "Password criteria not met") String password,
			LocalDate dob, String[] skills) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.skills = skills;
	}

	public Manager() {
		// TODO Auto-generated constructor stub
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

}
