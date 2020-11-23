package com.cts.model;

public class Enquiry {
	private long enquiryId;
	private long packageId;
	private String enquiry;
	private String email;
	private String enquiryReply;
	private static long i = 0;

	public String getEnquiryReply() {
		return enquiryReply;
	}

	public void setEnquiryReply(String enquiryReply) {
		this.enquiryReply = enquiryReply;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(long enquiryId) {
		this.enquiryId = enquiryId;
	}

	public long getPackageId() {
		return packageId;
	}

	public void setPackageId(long packageId) {
		this.packageId = packageId;
	}

	public String getEnquiry() {
		return enquiry;
	}

	public void setEnquiry(String enquiry) {
		this.enquiry = enquiry;
	}

	public static long generateEnquiryId() {
		return ++i;
	}

}
