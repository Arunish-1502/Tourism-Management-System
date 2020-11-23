package com.cts.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.cts.model.bookingDetails;

public interface bookingDetailsDao {
	public int addBookingDetails(bookingDetails bookingDetails) throws SQLException;
	public List<bookingDetails> extractBookingPackages() throws SQLException;
	public List<bookingDetails> extractBookingPackages(LocalDate start,LocalDate end)throws SQLException;
	public boolean validate(bookingDetails user);
}
