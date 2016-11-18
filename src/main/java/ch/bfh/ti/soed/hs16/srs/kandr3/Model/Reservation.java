/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.kandr3.Model;

public class Reservation {
	private User user;
	private Resource resource;
	private TimeRange timeRange;

	public Reservation(User user, Resource resource, TimeRange timeRange) {
		this.user=user;
		this.resource=resource;
		this.timeRange=timeRange;
	}

	public User getUser(){
		//return user.clone();
		return user;
	}

	public Resource getResource(){
		//return resource.clone();
		return resource;
	}

	public TimeRange getTimeRange(){
		return timeRange;
	}
}
