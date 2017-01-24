package ch.bfh.ti.soed.hs16.srs.kandr3.service;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;

import ch.bfh.ti.soed.hs16.srs.kandr3.controller.Controller;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.Administrator;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.AdministratorNotFoundException;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.Resource;

public class CreateResourceTest {

	// TODO Dieser Test läuft nicht...
	// @Test
	@Ignore
	public void testCreate() throws AdministratorNotFoundException {

		Administrator administrator = new Administrator("name");
		Controller controller = new Controller();
		controller.addAdministrator(administrator);
		Resource resource = new Resource("N101", 35, "Quellgasse 21");
		// TODO Sie verwenden @GeneratedValue(strategy = GenerationType.AUTO).
		// Somit dürfen Sie NICHT den ID setzen; JPA macht das automatisch.
		resource.setEid(1111);

		// Resource resource2 = FindResource.find(1111);
		// assertFalse(resource.getEid() == resource2.getEid());
		// assertTrue(resource2== null);

		controller.addResource(administrator, resource);

		// TODO Wie gesagt, JPA setzt den ID. Der ID-Wert ist sicher nicht 1111.
		Resource resource3 = FindResource.find(1111);
		// TODO Somit geht das hier nicht.
		// TODO Sie sollten equals() verwenden. Am besten so:
		// assertEquals(resource.getEid(), resource3.getEid()).
		assertTrue(resource.getEid() == resource3.getEid());

	}

}
