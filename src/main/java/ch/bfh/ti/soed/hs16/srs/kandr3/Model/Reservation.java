package ch.bfh.ti.soed.hs16.srs.kandr3;

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
