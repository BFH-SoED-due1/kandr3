/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.kandr3;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Set;

import org.junit.Test;

import ch.bfh.ti.soed.hs16.srs.kandr3.model.Reservation;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.Resource;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.TimeRange;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.User;

public class ReservationTest {

	@Test
	public void testMakeReservation() {
		User user = new User( "Peter M�ller");
		Resource resource = new Resource("room 101", 20, "Rolex Geb�ude");

		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(3, calendar2.get(2)+1);

		TimeRange timeRange = new TimeRange(calendar1, calendar2);


		// Der Benutzer reserviert den Raum und gibt as Zeitfenster an
		Reservation reservation = user.makeReservation(resource, timeRange);



		assertEquals(resource, reservation.getResource()); // Enth�lt die REservation die richtige Resource?
		assertEquals(user, reservation.getUser()); // Enth�lt die Reservation den richtigen User?



		Set<Reservation> reservationsOfResource = resource.getReservations();
		Set<Reservation> reservationsOfUser = user.getReservations();

		assertTrue(reservationsOfResource.contains(reservation)); // Ist der Resource die Reservation bekannt?
		assertTrue(reservationsOfUser.contains(reservation)); // Ist dem User die Reservation bekannt?


	}


}
