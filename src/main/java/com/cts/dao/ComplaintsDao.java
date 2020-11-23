package com.cts.dao;

import java.sql.SQLException;
import java.util.List;

import com.cts.model.Complaints;

public interface ComplaintsDao {

	public long save(Complaints user);
	
	public List<Complaints> extractComplaints() throws SQLException;
	
	public Complaints retrieveComplaint(int id) throws SQLException;
	
	public int updateReply(Complaints complaints) throws SQLException;
	
}
