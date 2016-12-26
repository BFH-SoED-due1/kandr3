/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.kandr3.model;

import ch.bfh.ti.soed.hs16.srs.kandr3.controller.Controller;

public class Administrator {
	private String name;

	public Administrator(String name) {
		this.name = name;
	}

	public void addResource(Controller controller, Resource resource) throws AdministratorNotFoundException {
		controller.addResource(this, resource);
	}
}
