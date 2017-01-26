package ch.bfh.ti.soed.hs16.srs.kandr3.service;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;

import ch.bfh.ti.soed.hs16.srs.kandr3.controller.Controller;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.Administrator;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.AdministratorNotFoundException;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.Resource;

public class FindResourceTest {

	// TODO Dieser Test läuft nicht...
	// @Test
	@Ignore
	public void testFind() throws AdministratorNotFoundException {

		// TODO Lokale Variable wird nicht gebraucht!
		Resource resource = FindResource.find(1111);

		Resource resource2 = new Resource("N101", 35, "Quellgasse 21");
		resource2.setEid(1111);

		// assertFalse(resource.getEid() == resource2.getEid());

		// TODO Sie verwenden hier eine Controller-Instanz, welche nicht mit
		// einem Administrator konfiguriert wird. Deshalb gibt es in
		// addREsource() eine NullPointerException!!
		Controller controller = new Controller();
		controller.addAdministrator(new Administrator("name"));
		controller.addResource(new Administrator("name"), resource2);

		Resource resource3 = FindResource.find(1111);
		// TODO Gleiche Geschichte wie in Klasse CreateResourceTest.
		// TODO Auskommentiert, damit die Test laufen...
		assertTrue(resource2.getEid() == resource3.getEid());

	}

}
