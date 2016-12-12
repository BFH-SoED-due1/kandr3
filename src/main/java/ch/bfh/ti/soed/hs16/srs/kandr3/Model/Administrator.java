package ch.bfh.ti.soed.hs16.srs.kandr3.Model;

import ch.bfh.ti.soed.hs16.srs.kandr3.Controller.Controller;

public class Administrator {
	String name;
	
	public Administrator(String name){
		this.name = name;
	}
	
	public void addResource(Controller controller, Resource resource){
		controller.addResource(resource);
	}
}
