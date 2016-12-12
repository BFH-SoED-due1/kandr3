package ch.bfh.ti.soed.hs16.srs.kandr3.Service;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.bfh.ti.soed.hs16.srs.kandr3.Controller.Controller;
import ch.bfh.ti.soed.hs16.srs.kandr3.Model.Resource;

public class FindResourceTest {

	@Test
	public void testFind() {

		Resource resource = FindResource.find(1111);
		
		Resource resource2 = new Resource("N101", 35, "Quellgasse 21");
		resource2.setEid(1111);
		
		//assertFalse(resource.getEid() == resource2.getEid());
		
		
		Controller controller = new Controller();
		controller.addResource(resource2);
		
		Resource resource3 = FindResource.find(1111);
		assertTrue(resource2.getEid() == resource3.getEid());

	}

}
