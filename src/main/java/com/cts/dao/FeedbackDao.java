package com.cts.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.cts.model.Feedback;
import com.cts.model.bookingDetails;

public interface FeedbackDao {
	public long save(Feedback feedback);

	public List<String> getFeedabckNames();

	public Feedback getAllQuestions(String name);

	public long saveAns(Feedback feedback);
	
	public List<Feedback> extractUserFeedback(LocalDate start, LocalDate end) throws SQLException;
}