package ch.bfh.ti.soed.hs16.srs.kandr3.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ch.bfh.ti.soed.hs16.srs.kandr3.Model.Resource;

public class DeleteResource {
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      EntityManager entitymanager = emfactory.createEntityManager( );
      entitymanager.getTransaction( ).begin( );


      Resource resource = entitymanager.find( Resource.class, 1201 );
      entitymanager.remove( resource );
      entitymanager.getTransaction( ).commit( );
      entitymanager.close( );
      emfactory.close( );
   }
}