package com.cts.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cts.dao.ConnectionDriver;
import com.cts.dao.TransactionDetailsDao;
import com.cts.model.TransactionDetails;
import com.cts.model.User;
import com.cts.model.bookingDetails;
import com.cts.model.packageDetails;

@Configuration
public class TransactionDetailsDaoImpl implements TransactionDetailsDao {
	
	@Autowired
	JdbcTemplate template;
	
	public int getTotalCost(bookingDetails bookingDetails) throws SQLException {
		String sql="select package_id, number_of_persons, mode_of_transport from package_booking_details where booking_id=?";
		bookingDetails details= template.queryForObject(sql, new Object[] { bookingDetails.getBookingId() }, new BeanPropertyRowMapper<bookingDetails>(bookingDetails.class));
		
		int totalCost=0;
		int packageId=details.getPackageId();
		int noOfPersons=details.getNumberOfPersons();
		int basePrice=getBaseCost(packageId);
		if(details.getModeOfTransport().equals("Airways")) {
			totalCost=(basePrice*noOfPersons)+(noOfPersons*5000);
		}
		
		else if(details.getModeOfTransport().equals("Railways")) {
			totalCost=(basePrice*noOfPersons)+(noOfPersons*1000);
		}
		
		else if(details.getModeOfTransport().equals("Roadways")) {
			totalCost=(basePrice*noOfPersons)+(noOfPersons*2000);
		}
		return totalCost;
	}
	
	public int getBaseCost(int packageId) throws SQLException {
		Connection con=ConnectionDriver.getConn();
		PreparedStatement stmt = con.prepareStatement("select * from package_details where package_id="+packageId);
		ResultSet rs = stmt.executeQuery();
		packageDetails packageDetails=new packageDetails();
		while(rs.next()) {
		packageDetails.setPackageCost(rs.getInt(5));
		}
		int baseCost=packageDetails.getPackageCost();
		return baseCost;
	}
	
	@Override
	public boolean extractTransactionDetails(TransactionDetails transactionDetails) throws SQLException{
		String sql="Select * from transaction_details where card_type=?";
		TransactionDetails details1= template.queryForObject(sql, new Object[] { transactionDetails.getCardType() }, new BeanPropertyRowMapper<TransactionDetails>(TransactionDetails.class));
		if(details1.getNameOnCard().equals(transactionDetails.getNameOnCard())) {
			if(details1.getCVV()==transactionDetails.getCVV()) {
					if(details1.getCardNumber().equals(transactionDetails.getCardNumber())) {
					//	if(details1.getExpirationDetails().equals(transactionDetails.getExpirationDetails())) {
						return true;
					
				//		else 
				//			return false;
					}
					else
					return false;		
			}
			else return false;
		}
		else
			return false;
	}
}

