/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.kandr3.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ch.bfh.ti.soed.hs16.srs.kandr3.model.Administrator;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.AdministratorNotFoundException;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.Reservation;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.ReservationNotFoundException;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.Resource;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.ResourceNotFoundException;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.TimeRange;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.User;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.UserNotFoundException;
import ch.bfh.ti.soed.hs16.srs.kandr3.service.CreateResource;

public class Controller {

	// TODO Hier verwenden Sie Listen mit POJO's...
	private List<User> user;
	private List<Resource> resource;
	private List<Reservation> reservation;
	private Administrator administrator;

	public Controller() {
		user = new ArrayList<User>();
		resource = new ArrayList<Resource>();
		reservation = new ArrayList<Reservation>();
	}

	public void addAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public void addUser(User user) {
		this.user.add(user);
	}

	public Reservation getReservation(int index) {
		return reservation.get(index);
	}

	public User getUser(int index) {
		return user.get(index);
	}

	public Resource getResource(int index) {
		return resource.get(index);
	}

	public void addResource(Administrator administrator, Resource resource) throws AdministratorNotFoundException {
		if (this.administrator.equals(administrator) == false)
			throw new AdministratorNotFoundException();
		// TODO Hier verwenden Sie immer noch die Liste mit POJO's.
		this.resource.add(resource);
		// TODO Und hier verwenden Sie JPA!! Das kann ja nicht gut gehen.
		CreateResource.create(resource.getEid(), resource.getDescription(), resource.getPlace(), resource.getSize());
	}

	public Reservation makeReservation(User user, Resource resource, TimeRange timeRange) {
		Reservation reservation = user.makeReservation(resource, timeRange);
		this.reservation.add(reservation);
		return reservation;
	}

	/**
	 *
	 * @param user
	 *            does a recurring reservation
	 * @param resource
	 *            is reserved in a recurring reservation
	 * @param timeRange
	 *            resource is reserved recurringly in the same time range
	 * @param repetition
	 *            specifies in how many succeeding weeks the reservation will
	 *            recur
	 * @return no return value
	 * @throws ResourceNotFoundException
	 *             is thrown if controller does not contain the specified
	 *             resource
	 * @throws UserNotFoundException
	 *             is thrown if controller does not contain the specified user
	 */
	public List<Reservation> makeRecurringReservation(User user, Resource resource, TimeRange timeRange, int repetition)
			throws ResourceNotFoundException, UserNotFoundException { // weekly
		if (this.resource.contains(resource) == false)
			throw new ResourceNotFoundException();
		if (this.user.contains(user) == false)
			throw new UserNotFoundException();

		List<Reservation> reservationList = new ArrayList<Reservation>();
		for (int i = 0; i <= repetition; i++) {
			TimeRange timeRange2 = timeRange.addWeeks(i);
			Reservation reservation = user.makeReservation(resource, timeRange2);
			reservationList.add(reservation);
			this.reservation.add(reservation);
		}
		return reservationList;
	}

	/**
	 *
	 * @param reservation
	 *            will be removed from the controller
	 * @throws ReservationNotFoundException
	 *             is thrown if the controller does not contain the specified
	 *             reservation
	 */
	public void cancelReservation(Reservation reservation) throws ReservationNotFoundException {
		if ((reservation.getUser().cancelReservation(reservation) && this.reservation.remove(reservation)
				&& reservation.getResource().cancelReservation(reservation)) == false)
			throw new ReservationNotFoundException();
	}

	public Resource getResource(Reservation reservation) throws ReservationNotFoundException {
		for (Reservation r : this.reservation) {
			if (r.equals(reservation)) {
				return r.getResource();
			}
		}
		throw new ReservationNotFoundException();
	}

	public User getUser(Reservation reservation) throws ReservationNotFoundException {
		for (Reservation r : this.reservation) {
			if (r.equals(reservation)) {
				return r.getUser();
			}
		}
		throw new ReservationNotFoundException();
	}

	public Set<Reservation> getReservations(Resource resource) throws ResourceNotFoundException {
		for (Resource r : this.resource) {
			if (r.equals(resource)) {
				return r.getReservations();
			}
		}
		throw new ResourceNotFoundException();
	}

	public Set<Reservation> getReservations(User user) throws UserNotFoundException {
		for (User u : this.user) {
			if (u.equals(user)) {
				return u.getReservations();
			}
		}
		throw new UserNotFoundException();
	}
}
