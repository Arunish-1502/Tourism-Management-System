package com.cts.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;

import org.springframework.format.annotation.DateTimeFormat;

import com.cts.service.packageListDaoImpl;

public class bookingDetails {
	
	private int bookingId;
	private int packageId;
	@Email(message = "Invalid Email Id")
	private String userId;
	private int numberOfPersons;
	private int numberOfRoomsRequired;
	private String modeOfTransport;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfTravel;
	private static int i = 1000;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getNumberOfPersons() {
		return numberOfPersons;
	}

	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	public int getNumberOfRoomsRequired() {
		return numberOfRoomsRequired;
	}

	public void setNumberOfRoomsRequired(int numberOfRoomsRequired) {
		this.numberOfRoomsRequired = numberOfRoomsRequired;
	}

	public String getModeOfTransport() {
		return modeOfTransport;
	}

	public void setModeOfTransport(String modeOfTransport) {
		this.modeOfTransport = modeOfTransport;
	}

	public LocalDate getDateOfTravel() {
		return dateOfTravel;
	}

	public void setDateOfTravel(LocalDate dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}

	@Override
	public String toString() {
		return "bookingDetails [bookingId=" + bookingId + ", packageId=" + packageId + ", userId=" + userId
				+ ", numberOfPersons=" + numberOfPersons + ", numberOfRoomsRequired=" + numberOfRoomsRequired
				+ ", modeOfTransport=" + modeOfTransport + ", dateOfTravel=" + dateOfTravel + "]";
	}

	public int generateBookingId() {
		i++;
		this.bookingId=i;
		return i;
	}

}
