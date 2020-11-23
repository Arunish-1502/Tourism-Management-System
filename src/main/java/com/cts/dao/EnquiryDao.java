package com.cts.dao;

import java.sql.SQLException;
import java.util.List;

import com.cts.model.Enquiry;

public interface EnquiryDao {
	
	public long addEnquiry(Enquiry enquiry);
	public void updateManagerEnquiry(Enquiry enquiry) throws SQLException;
	public Enquiry retrieveEnquiry(int id) throws SQLException;
	public List<Enquiry> extractEnquiryManager() throws SQLException;

}
