package ch.bfh.ti.soed.hs16.srs.kandr3;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Set;

import org.junit.Test;

public class ReservationTest {

	@Test
	public void testMakeReservation() {
		User user = new User( "Peter M�ller");
		Resource resource = new Resource("room 101", 20, "Rolex Geb�ude");
		
		Date date1 = new Date();
		Date date2 = new Date();
		

		TimeRange timeRange = new TimeRange(date1, date2);
		
		      //Reservation reservation = new Reservation(user, resource, timeRange);
		// Der Benutzer reserviert den Raum und gibt as Zeitfenster an
		Reservation reservation = user.makeReservation(resource, timeRange);
		
		//user.addReservation(reservation);
		//resource.addReservation(reservation);
		
		assertEquals(resource, reservation.getResource()); // Enth�lt die REservation die richtige Resource?
		assertEquals(user, reservation.getUser()); // Enth�lt die Reservation den richtigen User?
		
		
		
		//assertEquals(resource.getReservation(0), reservation);
		//assertEquals(user.getReservation(0), reservation);
		
		Set<Reservation> reservationsOfResource = resource.getReservations();
		Set<Reservation> reservationsOfUser = user.getReservations();
		
		assertTrue(reservationsOfResource.contains(reservation)); // Ist der Resource die Reservation bekannt?
		assertTrue(reservationsOfUser.contains(reservation)); // Ist dem User die Reservation bekannt?
		
		System.out.println(reservation.getTimeRange());
	}
	
	@Test
	public void testCancelReservation(){
		//fail("test not yet implented");
	}
	
	@Test
	public void testMakeRecurringReservation(){
		//fail("test not yet implented");
	}
}
