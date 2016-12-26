package ch.bfh.ti.soed.hs16.srs.kandr3.Service;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.bfh.ti.soed.hs16.srs.kandr3.controller.Controller;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.Administrator;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.AdministratorNotFoundException;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.Resource;
import ch.bfh.ti.soed.hs16.srs.kandr3.service.FindResource;

public class FindResourceTest {

	@Test
	public void testFind() throws AdministratorNotFoundException {

		Resource resource = FindResource.find(1111);
		
		Resource resource2 = new Resource("N101", 35, "Quellgasse 21");
		resource2.setEid(1111);
		
		//assertFalse(resource.getEid() == resource2.getEid());
		
		
		Controller controller = new Controller();
		controller.addResource(new Administrator("name"),resource2);
		
		Resource resource3 = FindResource.find(1111);
		assertTrue(resource2.getEid() == resource3.getEid());

	}

}
