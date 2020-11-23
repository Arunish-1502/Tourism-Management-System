package com.cts.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cts.dao.ConnectionDriver;
import com.cts.dao.FeedbackDao;
import com.cts.model.Feedback;
import com.cts.model.Manager;
import com.cts.model.bookingDetails;

@Component
public class FeedbackDaoImpl implements FeedbackDao {
	@Autowired
	JdbcTemplate template;

	@Override
	public long save(Feedback manager) {
		long x=Feedback.generateNumber();
		String sql="Insert into feedback_questions values(?,?,?,?,?,?,?)";
		int update = template.update(sql,x,manager.getName(),manager.getQuestion1(),manager.getQuestion2(),manager.getQuestion3(),manager.getQuestion4(),manager.getQuestion5());
		if(update!=0)
			return x;
			else 
				return 0;
	}

	@Override
	public List<String> getFeedabckNames() {
		String sql="select name from feedback_questions";
		List<String> queryForList = template.queryForList(sql,String.class);
		return queryForList;
	}

	@Override
	public Feedback getAllQuestions(String name) {
		String sql="select * from feedback_questions where name=?";
		 Feedback queryForObject = template.queryForObject(sql, new Object[] { name },
					new BeanPropertyRowMapper<Feedback>(Feedback.class));
		return queryForObject;
	}

	@Override
	public long saveAns(Feedback feedback) {
		long x=Feedback.generateNumber();
		String sql="Insert into feedback_replies values(?,?,?,?,?,?,?,?)";
		int update = template.update(sql,x,feedback.getName(),feedback.getQuestion1(),feedback.getQuestion2(),feedback.getQuestion3(),feedback.getQuestion4(),feedback.getQuestion5(),new Date());
		if(update!=0)
			return x;
			else 
				return 0;
	}
	
	@Override
	public List<Feedback> extractUserFeedback(LocalDate start, LocalDate end) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionDriver.getConn();
		PreparedStatement st = con.prepareStatement("select * from feedback_replies where date_of_filling between ? and ?");
		st.setDate(1,java.sql.Date.valueOf(start));
		st.setDate(2,java.sql.Date.valueOf(end));
		List<Feedback> UserFeedbackList = new ArrayList<Feedback>();
		ResultSet rs = st.executeQuery();
		while (rs.next())
		{
			Feedback details = new Feedback();
			details.setFeedbackNo(rs.getInt(1));
			details.setName(rs.getString(2));
			details.setQuestion1(rs.getString(3));
			details.setQuestion2(rs.getString(4));
			details.setQuestion3(rs.getString(5));
			details.setQuestion4(rs.getString(6));
			details.setQuestion5(rs.getString(7));
			UserFeedbackList.add(details);
		}
		return UserFeedbackList;
	}
	

}