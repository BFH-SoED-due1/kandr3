package ch.bfh.ti.soed.hs16.srs.kandr3.Service;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.bfh.ti.soed.hs16.srs.kandr3.Controller.Controller;
import ch.bfh.ti.soed.hs16.srs.kandr3.Model.Resource;
import ch.bfh.ti.soed.hs16.srs.kandr3.Service.*;

public class CreateResourceTest {

	@Test
	public void testCreate() {
		
		
		Controller controller = new Controller();
		Resource resource = new Resource("N101", 35, "Quellgasse 21");
		resource.setEid(1111);
		
		
		//Resource resource2 = FindResource.find(1111);
		//assertFalse(resource.getEid() == resource2.getEid());
			//assertTrue(resource2== null);
		
		
		controller.addResource(resource);
		
		Resource resource3 = FindResource.find(1111);
		assertTrue(resource.getEid() == resource3.getEid());
		
	}

}
