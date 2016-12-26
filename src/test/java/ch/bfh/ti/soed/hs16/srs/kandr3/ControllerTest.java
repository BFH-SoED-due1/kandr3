/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.kandr3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ch.bfh.ti.soed.hs16.srs.kandr3.controller.Controller;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.Administrator;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.AdministratorNotFoundException;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.Reservation;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.ReservationNotFoundException;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.Resource;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.ResourceNotFoundException;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.TimeRange;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.User;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.UserNotFoundException;

public class ControllerTest {

	@Test
	public void testMakeReservation() throws ReservationNotFoundException, ResourceNotFoundException, UserNotFoundException, AdministratorNotFoundException{
		Controller controller = new Controller();

		User user = new User( "Peter M�ller");
		controller.addUser(user);
		Resource resource = new Resource("room 101", 20, "Rolex Geb�ude");
		Administrator administrator = new Administrator("administrator");
		controller.addAdministrator(administrator);
		controller.addResource(administrator, resource);

		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();

		TimeRange timeRange = new TimeRange(calendar1, calendar2);

		// Der Benutzer reserviert den Raum und gibt as Zeitfenster an
		Reservation reservation = controller.makeReservation(user, resource, timeRange);

		assertEquals(resource, controller.getResource(reservation)); // Enth�lt die REservation die richtige Resource?
		assertEquals(user, controller.getUser(reservation)); // Enth�lt die Reservation den richtigen User?



		Set<Reservation> reservationsOfResource = controller.getReservations(resource);
		Set<Reservation> reservationsOfUser = controller.getReservations(user);

		assertTrue(reservationsOfResource.contains(reservation)); // Ist der Resource die Reservation bekannt?
		assertTrue(reservationsOfUser.contains(reservation)); // Ist dem User die Reservation bekannt?


	}

	@Test
	public void testCancelReservation() throws ReservationNotFoundException, ResourceNotFoundException, UserNotFoundException, AdministratorNotFoundException{
		Controller controller = new Controller();

		User user = new User( "Peter M�ller");
		controller.addUser(user);
		Resource resource = new Resource("room 101", 20, "Rolex Geb�ude");
		Administrator administrator = new Administrator("administrator");
		controller.addAdministrator(administrator);

		controller.addResource(administrator, resource);

		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();

		TimeRange timeRange = new TimeRange(calendar1, calendar2);

		// Der Benutzer reserviert den Raum und gibt as Zeitfenster an
		Reservation reservation = controller.makeReservation(user, resource, timeRange);


		assertEquals(resource, controller.getResource(reservation)); // Enth�lt die REservation die richtige Resource?
		assertEquals(user, controller.getUser(reservation)); // Enth�lt die Reservation den richtigen User?


		Set<Reservation> reservationsOfResource = controller.getReservations(resource);
		Set<Reservation> reservationsOfUser = controller.getReservations(user);

		assertTrue(reservationsOfResource.contains(reservation)); // Ist der Resource die Reservation bekannt?
		assertTrue(reservationsOfUser.contains(reservation)); // Ist dem User die Reservation bekannt?


		controller.cancelReservation(reservation);


		Set<Reservation> reservationsOfResource2 = controller.getReservations(resource);
		Set<Reservation> reservationsOfUser2 = controller.getReservations(user);

		assertFalse(reservationsOfResource2.contains(reservation)); // Die Reservation sollte nicht mehr in der Liste der Resource enthalten sein
		assertFalse(reservationsOfUser2.contains(reservation)); // Die Reservation sollte nicht mehr in der Liste des Users enthalten sein
	}

	@Test
	public void testMakeRecurringReservation() throws ResourceNotFoundException, UserNotFoundException, AdministratorNotFoundException{
Controller controller = new Controller();

		User user = new User( "Peter M�ller");
		controller.addUser(user);
		Resource resource = new Resource("room 101", 20, "Rolex Geb�ude");
		Administrator administrator = new Administrator("administrator");
		controller.addAdministrator(administrator);

		controller.addResource(administrator, resource);
		TimeRange timeRange = new TimeRange();

		// Der Benutzer reserviert den Raum und gibt as Zeitfenster an
		int repetition = 2;
		List<Reservation> reservation = controller.makeRecurringReservation(user, resource, timeRange, repetition);


		Set<Reservation> reservationsOfResource = resource.getReservations();
		Set<Reservation> reservationsOfUser = user.getReservations();

		for(int i=0; i<=repetition; i++){
			assertEquals(resource, reservation.get(i).getResource()); // Enth�lt die REservation die richtige Resource?
			assertEquals(user, reservation.get(i).getUser()); // Enth�lt die Reservation den richtigen User?


			assertTrue(reservationsOfResource.contains(reservation.get(i))); // Ist der Resource die Reservation bekannt?
			assertTrue(reservationsOfUser.contains(reservation.get(i))); // Ist dem User die Reservation bekannt?
		}


			TimeRange timeRange1 = reservation.get(0).getTimeRange();
			TimeRange timeRange2 = reservation.get(1).getTimeRange();
			TimeRange timeRange3 = reservation.get(2).getTimeRange();



			assertFalse(timeRange1.getCalendar1().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar1().get(Calendar.DAY_OF_MONTH));
			timeRange1.getCalendar1().add(Calendar.DAY_OF_MONTH, 7);
			timeRange1.getCalendar2().add(Calendar.DAY_OF_MONTH, 7);

			assertTrue(timeRange1.getCalendar1().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar1().get(Calendar.DAY_OF_MONTH));
			assertTrue(timeRange1.getCalendar2().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar2().get(Calendar.DAY_OF_MONTH));


			assertFalse(timeRange2.getCalendar1().get(Calendar.DAY_OF_MONTH)==timeRange3.getCalendar1().get(Calendar.DAY_OF_MONTH));
			timeRange2.getCalendar1().add(Calendar.DAY_OF_MONTH, 7);
			timeRange2.getCalendar2().add(Calendar.DAY_OF_MONTH, 7);

			assertTrue(timeRange2.getCalendar1().get(Calendar.DAY_OF_MONTH)==timeRange3.getCalendar1().get(Calendar.DAY_OF_MONTH));
			assertTrue(timeRange2.getCalendar2().get(Calendar.DAY_OF_MONTH)==timeRange3.getCalendar2().get(Calendar.DAY_OF_MONTH));


			}

	@Test
	public void testMakeRecurringReservation2(){

		User user = new User( "Peter M�ller");

		Resource resource = new Resource("room 101", 20, "Rolex Geb�ude");

		TimeRange timeRange = new TimeRange();

		List<Reservation> reservationList = new ArrayList<Reservation>();

		Reservation reservation = user.makeReservation(resource, timeRange);
		reservationList.add(reservation);
		TimeRange timeRanget = timeRange.addWeeks(1);
		Reservation reservation2 = user.makeReservation(resource, timeRanget);
		reservationList.add(reservation2);


		TimeRange timeRange1 = reservationList.get(0).getTimeRange();
		TimeRange timeRange2 = reservationList.get(1).getTimeRange();

		
		assertFalse(timeRange1.getCalendar1().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar1().get(Calendar.DAY_OF_MONTH));
		assertFalse(timeRange1.getCalendar2().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar2().get(Calendar.DAY_OF_MONTH));
		timeRange1.getCalendar1().add(Calendar.DAY_OF_MONTH, 7);
		timeRange1.getCalendar2().add(Calendar.DAY_OF_MONTH, 7);
		assertTrue(timeRange1.getCalendar1().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar1().get(Calendar.DAY_OF_MONTH));
		assertTrue(timeRange1.getCalendar2().get(Calendar.DAY_OF_MONTH)==timeRange2.getCalendar2().get(Calendar.DAY_OF_MONTH));

	}
}
