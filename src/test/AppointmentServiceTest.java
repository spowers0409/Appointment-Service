package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.AppointmentService;

public class AppointmentServiceTest {
	private String ID, description, longDescription;
	private Date date, pastDate;
	
	// Info bin to add working and non-working info for tests
	@SuppressWarnings("deprecation")
	@BeforeEach
	void infoBin() {
		ID = "0000000001";
		description = "This is a description line";
		date = new Date(2022, Calendar.FEBRUARY, 3);
		longDescription = "This is a description line that is far too long for this to work!";
		pastDate = new Date(0);
	}
	
	// Test to add appointments 
	@Test
	void testAddAppointment() {
		AppointmentService service = new AppointmentService();
		
		service.newAppointment();
		assertNotNull(service.getAppointmentList().get(0).getAppointmentID());
		assertNotNull(service.getAppointmentList().get(0).getDescription());
		assertNotNull(service.getAppointmentList().get(0).getAppointmentDate());
		
		service.newAppointment(date);
		assertNotNull(service.getAppointmentList().get(1).getAppointmentID());
		assertEquals(date, service.getAppointmentList().get(1).getAppointmentDate());
		assertNotNull(service.getAppointmentList().get(1).getAppointmentDate());
		
		service.newAppointment(date, description);
		assertNotNull(service.getAppointmentList().get(2).getAppointmentID());
		assertEquals(date, service.getAppointmentList().get(2).getAppointmentDate());
		assertEquals(description, service.getAppointmentList().get(2).getDescription());
		
		assertNotEquals(service.getAppointmentList().get(0).getAppointmentID(),
				service.getAppointmentList().get(1).getAppointmentID());
		assertNotEquals(service.getAppointmentList().get(0).getAppointmentID(),
				service.getAppointmentList().get(2).getAppointmentID());
		assertNotEquals(service.getAppointmentList().get(1).getAppointmentID(),
				service.getAppointmentList().get(2).getAppointmentID());
		
		assertThrows(IllegalArgumentException.class,
				() -> service.newAppointment(pastDate));
		assertThrows(IllegalArgumentException.class,
				() -> service.newAppointment(date, longDescription));
	}
	
	// Test to delete appointments
	@Test
	void deleteAppointment() throws Exception {
		AppointmentService service = new AppointmentService();
		
		service.newAppointment();
		service.newAppointment();
		service.newAppointment();
		
		String IDOne = service.getAppointmentList().get(0).getAppointmentID();
		String IDTwo = service.getAppointmentList().get(1).getAppointmentID();
		String IDThree = service.getAppointmentList().get(2).getAppointmentID();
		
		assertNotEquals(IDOne, IDTwo);
		assertNotEquals(IDOne, IDThree);
		assertNotEquals(IDTwo, IDThree);
		assertNotEquals(ID, IDOne);
		assertNotEquals(ID, IDTwo);
		assertNotEquals(ID, IDThree);
		
		assertThrows(Exception.class,
				() -> service.deleteAppointment(ID));
		
		service.deleteAppointment(IDOne);
		assertThrows(Exception.class,
				() -> service.deleteAppointment(IDOne));
		assertNotEquals(IDOne, service.getAppointmentList().get(0).getAppointmentID());
	}

}
