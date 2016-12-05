package ch.bfh.ti.soed.hs16.srs.kandr3.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ch.bfh.ti.soed.hs16.srs.kandr3.Model.Resource;

public class FindResource {
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      EntityManager entitymanager = emfactory.createEntityManager();
      Resource resource = entitymanager.find( Resource.class, 1201 );

      System.out.println("employee ID = " + resource.getEid( ));
      System.out.println("employee DESCRIPTION = " + resource.getDescription());
      System.out.println("employee PLACE = " + resource.getPlace());
      System.out.println("employee RESERVATIONS = " + resource.getReservations());
      System.out.println("employee SIZE = " + resource.getSize());
   }
}