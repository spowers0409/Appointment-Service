package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {
	final private List<Appointment> appointmentList = new ArrayList<>();
	
	private String newUUID() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
	public void newAppointment() {
		Appointment appointment = new Appointment(newUUID());
		appointmentList.add(appointment);
	}
	
	public void newAppointment(Date date) {
		Appointment appointment = new Appointment(newUUID(), date);
		appointmentList.add(appointment);
	}
	
	public void newAppointment(Date date, String description) {
		Appointment appointment = new Appointment(newUUID(), date, description);
		appointmentList.add(appointment);
	}
	
	public void deleteAppointment(String ID) throws Exception {
		appointmentList.remove(searchAppointment(ID));
	}
	
	protected List<Appointment> getAppointmentList() { return appointmentList; }
	
	private Appointment searchAppointment(String ID) throws Exception {
		int index = 0;
		while(index < appointmentList.size()) {
			if(ID.equals(appointmentList.get(index).getAppointmentID() )) {
				return appointmentList.get(index);
			}
			index++;
		}
		throw new Exception("Not a valid appointment");
	}
}
