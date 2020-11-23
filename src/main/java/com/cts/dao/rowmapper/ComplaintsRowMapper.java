package com.cts.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.model.Complaints;

public class ComplaintsRowMapper implements RowMapper<Complaints> {

	@Override
	public Complaints mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Complaints complaints=new Complaints();
		complaints.setComplaintNo(rs.getLong(1));
		complaints.setComplaint(rs.getString(2));
		complaints.setReply(rs.getString(3));
		complaints.setStatus(rs.getString(4));
		return complaints;
	}

}
