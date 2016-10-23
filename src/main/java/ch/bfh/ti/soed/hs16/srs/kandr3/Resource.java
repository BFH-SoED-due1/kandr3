package ch.bfh.ti.soed.hs16.srs.kandr3;

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
}
