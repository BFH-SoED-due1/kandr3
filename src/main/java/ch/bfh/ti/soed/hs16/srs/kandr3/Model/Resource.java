/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.kandr3.Model;

import java.util.HashSet;
import java.util.Set;

public class Resource {

	private String despription;
	private int size;
	private String place;
	private Set<Reservation> reservations;

	public Resource(String string, int i, String string2) {
		// TODO Auto-generated constructor stub
		despription = string;
		size = i;
		place = string2;
		reservations = new HashSet<Reservation>();
	}

	@Override
	public Resource clone(){
		Resource resource = new Resource(this.despription, this.size, this.place);
		return resource;
	}

	public Set<Reservation> getReservations(){
		return reservations;
	}

	public void addReservation(Reservation reservation){
		reservations.add(reservation);
	}

	public boolean cancelReservation(Reservation reservation) {
		return this.reservations.remove(reservation);
	}
}
