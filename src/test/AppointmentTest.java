package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Appointment;

public class AppointmentTest {
	
	private String ID, description;
	private String longID, longDescription;
	private Date date, pastDate;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void infoBin() {
		ID = "0000000001";
		description = "This is a desciption line";
		date = new Date(2022, Calendar.FEBRUARY, 3);
		longID = "00000000001";
		longDescription = "This is a description line that is far too long for this to work!";
		pastDate = new Date(0);
	}
	
	@Test
	void testUpdateAppointmentID() {
		Appointment appointment = new Appointment();
		assertThrows(IllegalArgumentException.class,
				() -> appointment.updateAppointmentID(null));
		assertThrows(IllegalArgumentException.class,
				() -> appointment.updateAppointmentID(longID));
		appointment.updateAppointmentID(ID);
		assertEquals(ID, appointment.getAppointmentID());
	}
	
	@Test
	void testGetAppointmentID() {
		Appointment appointment = new Appointment(ID);
		assertNotNull(appointment.getAppointmentID());
		assertEquals(appointment.getAppointmentID().length(), 10);
		assertEquals(ID, appointment.getAppointmentID());
	}
	
	@Test
	void testUpdateDescription() {
		Appointment appointment = new Appointment();
		assertThrows(IllegalArgumentException.class,
				() -> appointment.updateDescription(null));
		assertThrows(IllegalArgumentException.class,
				() -> appointment.updateDescription(longDescription));
		appointment.updateDescription(description);
		assertEquals(description, appointment.getDescription());
	}
	
	@Test
	void testGetDescription() {
		Appointment appointment = new Appointment(ID, date, description);
		assertNotNull(appointment.getDescription());
		assertTrue(appointment.getDescription().length() <= 50);
		assertEquals(description, appointment.getDescription());
	}
	
	@Test
	void testUpdateDate() {
		Appointment appointment = new Appointment();
		assertThrows(IllegalArgumentException.class,
				() -> appointment.updateDate(null));
		assertThrows(IllegalArgumentException.class,
				() -> appointment.updateDate(pastDate));
		appointment.updateDate(date);
		assertEquals(date, appointment.getAppointmentDate());
	}
	
	@Test
	void testGetAppointmentDate() {
		Appointment appointment = new Appointment(ID, date);
		assertNotNull(appointment.getAppointmentDate());
		assertEquals(date, appointment.getAppointmentDate());
	}
}
