package com.cts.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cts.dao.ComplaintsDao;
import com.cts.dao.rowmapper.ComplaintsRowMapper;
import com.cts.model.Complaints;
import com.cts.model.bookingDetails;



@Component
public class ComplaintsDaoImpl implements ComplaintsDao {

	@Autowired
	JdbcTemplate template;
	

	@Override
	public long save(Complaints user) {
		// TODO Auto-generated method stub
		long x=user.generateComplaintNo();
		String sql="Insert into user_complaints values(?,?,?,?)";
		int update = template.update(sql,x,user.getComplaint(),user.getReply(),"In Progress");
		if(update!=0)
		return x;
		else 
			return 0;
	}


	@Override
	public List<Complaints> extractComplaints() throws SQLException {
	
	ComplaintsRowMapper rowMapper=new ComplaintsRowMapper();
	String sql="select * from user_complaints";
	List<Complaints> result= template.query(sql, rowMapper);
	return result;
		
	}
	
	@Override
	public Complaints retrieveComplaint(int id) throws SQLException {
		List<Complaints> list= extractComplaints();
			for(Complaints details: list)
			{
				if (details.getComplaintNo()==id) {
					return details;
			}
				}
			return null;
		
		}


	@Override
	public int updateReply(Complaints complaints) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update user_complaints set Reply=?,Status=? where complaintNo=?";
		int res=template.update(sql,complaints.getReply(),"Completed",complaints.getComplaintNo());
		return res;
		
	}
	
}
