/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.kandr3.model;

import java.util.HashSet;
import java.util.Set;

public class User {
	private String name;
	private Set<Reservation> reservations;

	public User(String name) {
		this.name = name;
		reservations = new HashSet<Reservation>();
	}

	@Override
	public User clone() {
		User user = new User(this.name);
		return user;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}

	public Reservation makeReservation(Resource resource, TimeRange timeRange) {

		Reservation reservation = new Reservation(this, resource, timeRange);
		this.addReservation(reservation);
		resource.addReservation(reservation);
		return reservation;
	}

	public boolean cancelReservation(Reservation reservation) {
		return this.reservations.remove(reservation);
	}
}
