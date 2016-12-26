/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.kandr3.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.ti.soed.hs16.srs.kandr3.model.Resource;

public class Ordering {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();

		// Between
		Query query = entitymanager.createQuery("Select r " + "from Resource r " + "ORDER BY r.description ASC");

		List<Resource> list = query.getResultList();

		for (Resource r : list) {
			System.out.print("Employee ID :" + r.getEid());
			System.out.println("\t Employee Name :" + r.getDescription());
		}
	}
}
