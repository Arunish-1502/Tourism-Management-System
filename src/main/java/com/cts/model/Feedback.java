package com.cts.model;

public class Feedback {
	private long feedbackNo;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private static long i = 0;
	private String question1;
	private String question2;

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getQuestion4() {
		return question4;
	}

	public void setQuestion4(String question4) {
		this.question4 = question4;
	}

	public String getQuestion5() {
		return question5;
	}

	public void setQuestion5(String question5) {
		this.question5 = question5;
	}

	private String question3;
	private String question4;
	private String question5;

	public long getFeedbackNo() {
		return feedbackNo;
	}

	public void setFeedbackNo(long feedbackNo) {
		this.feedbackNo = feedbackNo;
	}

	public static long generateNumber() {
		return ++i;
	}

}