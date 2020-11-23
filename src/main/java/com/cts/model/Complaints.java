package com.cts.model;

public class Complaints {

	private long complaintNo;
	private String complaint;
	private static long i=3025;
	private String reply;
	private String status;
	
	public long getComplaintNo() {
		return complaintNo;
	}
	public void setComplaintNo(long complaintNo) {
		this.complaintNo = complaintNo;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public long generateComplaintNo() 
	{
		return i++;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Complaints [complaintNo=" + complaintNo + ", complaint=" + complaint + ", reply=" + reply + ", status="
				+ status + "]";
	}
	
	
	
	
	}

