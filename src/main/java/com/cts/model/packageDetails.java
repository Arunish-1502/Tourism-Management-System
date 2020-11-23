package com.cts.model;

public class packageDetails {
	private int packageId;
	private String packageName;
	private String location;
	private String duration;
	private int packageCost;
	private static int i=150;

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(int packageCost) {
		this.packageCost = packageCost;
	}

	@Override
	public String toString() {
		return "packageDetails [packageId=" + packageId + ", packageName=" + packageName + ", location=" + location
				+ ", duration=" + duration + ", packageCost=" + packageCost + "]";
	}
	
	
	public int generatePackageId() {
		return i++;
	}

}
