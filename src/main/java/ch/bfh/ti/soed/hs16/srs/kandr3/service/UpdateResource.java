/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.kandr3.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bfh.ti.soed.hs16.srs.kandr3.model.Resource;

public class UpdateResource {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Resource resource = entitymanager.find(Resource.class, 1201);

		// before update
		System.out.println(resource);
		resource.setSize(100);
		entitymanager.getTransaction().commit();

		// after update
		System.out.println(resource);
		entitymanager.close();
		emfactory.close();
	}
}
