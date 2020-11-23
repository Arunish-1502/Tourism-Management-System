package com.cts.service;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cts.dao.ConnectionDriver;
import com.cts.dao.bookingDetailsDao;
import com.cts.model.bookingDetails;
import com.cts.model.packageDetails;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Configuration
public class bookingDetailsDaoImpl implements bookingDetailsDao {
	
	@Autowired
	JdbcTemplate template;
	
	public int addBookingDetails(bookingDetails bookingDetails) throws SQLException {
		Connection con=ConnectionDriver.getConn();
		String insertString="insert into package_booking_details values(?,?,?,?,?,?,?)";
		PreparedStatement st=con.prepareStatement(insertString);
		st.setInt(1, bookingDetails.generateBookingId());
		st.setInt(2,bookingDetails.getPackageId());
		st.setString(3,bookingDetails.getUserId());
		st.setInt(4, bookingDetails.getNumberOfPersons());
		st.setInt(5, bookingDetails.getNumberOfRoomsRequired());
		st.setString(6, bookingDetails.getModeOfTransport());
		st.setDate(7, java.sql.Date.valueOf(bookingDetails.getDateOfTravel()));
		int k=st.executeUpdate();
		return k;
	}
	
	public List<bookingDetails> extractBookingPackages() throws SQLException{
		Connection con=ConnectionDriver.getConn();
		PreparedStatement st = con.prepareStatement("select * from package_booking_details");
		List<bookingDetails> UserBookingDetailsList = new ArrayList<bookingDetails>();
		ResultSet rs = st.executeQuery();
		while (rs.next())
		{
			bookingDetails details = new bookingDetails();
			details.setBookingId(rs.getInt(1));
			details.setPackageId(rs.getInt(2));
			details.setUserId(rs.getString(3));
			details.setNumberOfPersons(rs.getInt(4));
			details.setNumberOfRoomsRequired(rs.getInt(5));
			details.setModeOfTransport(rs.getString(6));
			details.setDateOfTravel(rs.getDate(7).toLocalDate());
			UserBookingDetailsList.add(details);
		}
		return UserBookingDetailsList;
	}
	
	@Override
	public List<bookingDetails> extractBookingPackages(LocalDate start, LocalDate end) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionDriver.getConn();
		PreparedStatement st = con.prepareStatement("select * from package_booking_details where date_of_travel between ? and ?");
		st.setDate(1,java.sql.Date.valueOf(start));
		st.setDate(2,java.sql.Date.valueOf(end));
		List<bookingDetails> UserBookingDetailsList = new ArrayList<bookingDetails>();
		ResultSet rs = st.executeQuery();
		while (rs.next())
		{
			bookingDetails details = new bookingDetails();
			details.setBookingId(rs.getInt(1));
			details.setPackageId(rs.getInt(2));
			details.setUserId(rs.getString(3));
			details.setDateOfTravel(rs.getDate(7).toLocalDate());
			UserBookingDetailsList.add(details);
		}
		return UserBookingDetailsList;
	}
	
	@Override
	public boolean validate(bookingDetails user) {
		String sql="Select count(booking_id) as b_count from package_booking_details where booking_id=?";
	    int row= template.queryForObject(sql, new Object[] { user.getBookingId() }, Integer.class).intValue();
	    if(row==1)
			return true;
		else
			return false;
	}

	public void generateReportForBuyer(LocalDate date1, LocalDate date2) throws Exception {
		List<bookingDetails> list=extractBookingPackages(date1, date2);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("booking_packages_report_"+date1+"-"+date2);

		XSSFRow row = spreadsheet.createRow(1);
		XSSFCell cell;
		cell = row.createCell(1);
		cell.setCellValue("BOOKING ID");
		cell = row.createCell(2);
		cell.setCellValue("PACKAGE ID");
		cell = row.createCell(3);
		cell.setCellValue("USER ID");
		cell = row.createCell(4);
		cell.setCellValue("DATE OF TRAVEL");
		int i = 2;

		for (bookingDetails details : list) {
			row = spreadsheet.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue(details.getBookingId());
			cell = row.createCell(2);
			cell.setCellValue(details.getPackageId());
			cell = row.createCell(3);
			cell.setCellValue(details.getUserId());
			cell = row.createCell(4);
			LocalDate reqDate=details.getDateOfTravel();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String requiredDate=reqDate.format(formatter);
			cell.setCellValue(requiredDate);
			i++;
		}
		FileOutputStream out = new FileOutputStream(new File("booking_packages_report.xlsx"));
		workbook.write(out);
		out.close();
	}
}
