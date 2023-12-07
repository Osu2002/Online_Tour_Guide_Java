package com.info.model;

public class Information {
	
	private String infoID;
	private String locationID;
	private String heading;
	private String description;
	
	public Information() {
		super();
		this.infoID = "";
		this.locationID = "";
		this.heading = "";
		this.description = "";
	}


	public String getInfoID() {
		return infoID;
	}
	public void setInfoID(String infoID) {
		this.infoID = infoID;
	}
	public String getLocationID() {
		return locationID;
	}
	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
