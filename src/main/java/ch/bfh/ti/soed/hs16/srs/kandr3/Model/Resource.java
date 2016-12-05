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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(query = "Select r from Resource r where r.eid = :id", name = "find resource by id")

public class Resource {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	
	private int eid;
	private String description;
	private int size;
	private String place;
	private Set<Reservation> reservations;
	
	public Resource(){
		
	}

	public Resource(String string, int i, String string2) {
		// TODO Auto-generated constructor stub
		description = string;
		size = i;
		place = string2;
		reservations = new HashSet<Reservation>();
	}

	@Override
	public Resource clone(){
		Resource resource = new Resource(this.description, this.size, this.place);
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
	
	
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "Resource [eid=" + eid + ", despription=" + description + ", size=" + size + ", place=" + place
				+ ", reservations=" + reservations + "]";
	}
}
