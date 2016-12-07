package ch.bfh.ti.soed.hs16.srs.kandr3.Service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ch.bfh.ti.soed.hs16.srs.kandr3.Model.Resource;

public class NamedQueries {
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      EntityManager entitymanager = emfactory.createEntityManager();
      Query query = entitymanager.createNamedQuery("find resource by id");
      
      query.setParameter("id", 1204);
      List<Resource> list = query.getResultList( );
      
      for( Resource r:list ){
         System.out.print("Resource ID :" + r.getEid( ));
         System.out.println("\t Resource Description :" + r.getDescription( ));
      }
   }
}