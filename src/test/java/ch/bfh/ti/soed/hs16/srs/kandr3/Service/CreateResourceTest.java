package ch.bfh.ti.soed.hs16.srs.kandr3.Service;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.bfh.ti.soed.hs16.srs.kandr3.controller.Controller;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.Administrator;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.AdministratorNotFoundException;
import ch.bfh.ti.soed.hs16.srs.kandr3.model.Resource;
import ch.bfh.ti.soed.hs16.srs.kandr3.service.*;

public class CreateResourceTest {

	@Test
	public void testCreate() throws AdministratorNotFoundException {
		
		Administrator administrator= new Administrator("name");
		Controller controller = new Controller();
		controller.addAdministrator(administrator);
		Resource resource = new Resource("N101", 35, "Quellgasse 21");
		resource.setEid(1111);
		
		
		//Resource resource2 = FindResource.find(1111);
		//assertFalse(resource.getEid() == resource2.getEid());
			//assertTrue(resource2== null);
		
		
		controller.addResource(administrator,resource);
		
		Resource resource3 = FindResource.find(1111);
		assertTrue(resource.getEid() == resource3.getEid());
		
	}

}
