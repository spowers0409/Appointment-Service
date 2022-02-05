package main;

import java.util.Date;

public class Appointment {
	
	final private byte appointmentIDLength;
	final private byte appointmentDescriptionLength;
	final private String INITIALIZER;
	private String appointmentID;
	private String description;
	private Date appointmentDate;
	
	{
		appointmentIDLength = 10;
		appointmentDescriptionLength = 50;
		INITIALIZER = "INITIAL";
	}
	
	public Appointment() {
		Date today = new Date();
		appointmentID = INITIALIZER;
		appointmentDate = today;
		description = INITIALIZER;
	}
	
	public Appointment(String id) {
		Date today = new Date();
		updateAppointmentID(id);
		appointmentDate = today;
		description = INITIALIZER;
	}
	
	public Appointment(String id, Date date) {
		updateAppointmentID(id);
		updateDate(date);
		description = INITIALIZER;
	}
	
	public Appointment(String id, Date date, String description) {
		updateAppointmentID(id);
		updateDate(date);
		updateDescription(description);
	}
	
	public void updateAppointmentID(String id) {
		if(id == null) {
			throw new IllegalArgumentException("Appointment ID null!");
		}
		else if(id.length() > appointmentIDLength) {
			throw new IllegalArgumentException("Appoinemtn ID cannot be longer than " + appointmentIDLength + " characters!");
		}
		else {
			this.appointmentID = id;
			}
		}
	public String getAppointmentID() { return appointmentID; }
	
	public void updateDate(Date date) {
		if(date == null) {
			throw new IllegalArgumentException("Appointment date null");
		}
		else if(date.before(new Date())) {
			throw new IllegalArgumentException("Error - date is in the past");
		}
		else {
			this.appointmentDate = date;
		}
	}
	
	public Date getAppointmentDate() { return appointmentDate; }
	
	public void updateDescription(String description) {
		if(description == null) {
			throw new IllegalArgumentException("Description is null");
		}
		else if(description.length() > appointmentDescriptionLength) {
			throw new IllegalArgumentException("Appointment description cannot be longer than " + appointmentDescriptionLength + " characters!");
		}
		else {
			this.description = description;
		}		
	}
	
	public String getDescription() { return description; }
}
