/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.kandr3.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ch.bfh.ti.soed.hs16.srs.kandr3.Model.Reservation;
import ch.bfh.ti.soed.hs16.srs.kandr3.Model.ReservationNotFoundException;
import ch.bfh.ti.soed.hs16.srs.kandr3.Model.Resource;
import ch.bfh.ti.soed.hs16.srs.kandr3.Model.ResourceNotFoundException;
import ch.bfh.ti.soed.hs16.srs.kandr3.Model.TimeRange;
import ch.bfh.ti.soed.hs16.srs.kandr3.Model.User;
import ch.bfh.ti.soed.hs16.srs.kandr3.Model.UserNotFoundException;

public class Controller {

	private List<User> user;
	private List<Resource> resource;
	private List<Reservation> reservation;

	public Controller(){
		user = new ArrayList<User>();
		resource = new ArrayList<Resource>();
		reservation = new ArrayList<Reservation>();
	}

	public void addUser(User user){
		this.user.add(user);
	}

	public Reservation getReservation(int index){
		return reservation.get(index);
	}

	public User getUser(int index){
		return user.get(index);
	}



	public Resource getResource(int index){
		return resource.get(index);
	}

	public void addResource(Resource resource){
		this.resource.add(resource);
	}


	public Reservation makeReservation(User user, Resource resource, TimeRange timeRange){
		Reservation reservation =  user.makeReservation(resource, timeRange);
		this.reservation.add(reservation);
		return reservation;
	}

	/**
	 *
	 * @param user
	 * @param resource
	 * @param timeRange
	 * @param repetition specifies in how many succeeding weeks the reservation will recur
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws UserNotFoundException
	 */
	public List<Reservation> makeRecurringReservation(User user, Resource resource, TimeRange timeRange, int repetition) throws ResourceNotFoundException, UserNotFoundException{ //weekly
		if(this.resource.contains(resource)==false) throw new ResourceNotFoundException();
		if(this.user.contains(user)==false) throw new UserNotFoundException();

		List<Reservation> reservationList = new ArrayList<Reservation>();
		for(int i =0; i<=repetition; i++){
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
	 * @throws ReservationNotFoundException
	 */
	public void cancelReservation(Reservation reservation) throws ReservationNotFoundException{
		if( ( reservation.getUser().cancelReservation(reservation) &&
		this.reservation.remove(reservation) &&
		reservation.getResource().cancelReservation(reservation) ) == false)
			throw new ReservationNotFoundException();
	}

	public Resource getResource(Reservation reservation) throws ReservationNotFoundException {
		for(Reservation r : this.reservation){
			if(r.equals(reservation)){
				return r.getResource();
			}
		}
		throw new ReservationNotFoundException();
	}


	public User getUser(Reservation reservation) throws ReservationNotFoundException{
		for(Reservation r : this.reservation){
			if(r.equals(reservation)){
				return r.getUser();
			}
		}
		throw new ReservationNotFoundException();
	}

	public Set<Reservation> getReservations(Resource resource) throws ResourceNotFoundException{
		for(Resource r : this.resource){
			if(r.equals(resource)){
				return r.getReservations();
			}
		}
		throw new ResourceNotFoundException();
	}

	public Set<Reservation> getReservations(User user) throws UserNotFoundException{
		for(User u : this.user){
			if(u.equals(user)){
				return u.getReservations();
			}
		}
		throw new UserNotFoundException();
	}
}
