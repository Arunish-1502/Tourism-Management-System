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
import org.springframework.stereotype.Service;

import com.cts.dao.ConnectionDriver;
import com.cts.dao.EnquiryDao;
import com.cts.model.Enquiry;
import com.cts.model.User;
import com.cts.model.packageDetails;

@Configuration
public class EnquiryDaoImpl implements EnquiryDao {

	@Autowired
	JdbcTemplate template;

	@Override
	public long addEnquiry(Enquiry enquiry) {
		// TODO Auto-generated method stub
		String sql = "Insert into enquiry_table values(?,?,?,?,?)";
		int update = template.update(sql, Enquiry.generateEnquiryId(), enquiry.getPackageId(), enquiry.getEnquiry(),enquiry.getEmail(), enquiry.getEnquiryReply());
		return update;

	}
	
	@Override
	public List<Enquiry> extractEnquiryManager() throws SQLException{
		Connection con=ConnectionDriver.getConn();
		PreparedStatement st = con.prepareStatement("select * from enquiry_table");
		List<Enquiry> enquiryList = new ArrayList<Enquiry>();
		ResultSet rs = st.executeQuery();
		while (rs.next())
		{
			Enquiry details = new Enquiry();
			details.setEnquiryId(rs.getLong(1));
			details.setPackageId(rs.getLong(2));
			details.setEnquiry(rs.getString(3));
			details.setEmail(rs.getString(4));
			details.setEnquiryReply(rs.getString(5));
			enquiryList.add(details);
		}
		return enquiryList;
	}
	
	@Override
	public Enquiry retrieveEnquiry(int id) throws SQLException {
		List<Enquiry> list= extractEnquiryManager();
			for(Enquiry details: list)
			{
				if (details.getEnquiryId()==id) {
					return details;
			}}
			return null;
		
		}
	
	@Override
	public void updateManagerEnquiry(Enquiry enquiry) throws SQLException {
		String updateSQL="update enquiry_table set package_id=?, enquiry=?, email=?, enquiry_reply=? where enquiry_id=?";
		Connection con=ConnectionDriver.getConn();
		PreparedStatement st=con.prepareStatement(updateSQL);
		st.setLong(1, enquiry.getPackageId());
		st.setString(2, enquiry.getEnquiry());
		st.setString(3, enquiry.getEmail());
		st.setString(4, enquiry.getEnquiryReply());
		st.setLong(5, enquiry.getEnquiryId());
		int k=st.executeUpdate();
	}
}
