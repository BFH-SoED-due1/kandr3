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

public class CreateResource {

	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Resource resource = new Resource();
		resource.setEid(1201);
		resource.setDescription("description");
		resource.setPlace("place");
		resource.setSize(25);
		resource.setReservations(null);

		entitymanager.persist(resource);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}

	public static void create(int id, String description, String place, int size) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Resource resource = new Resource();
		resource.setEid(id);
		resource.setDescription(description);
		resource.setPlace(place);
		resource.setSize(size);
		resource.setReservations(null);

		entitymanager.persist(resource);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}
}
