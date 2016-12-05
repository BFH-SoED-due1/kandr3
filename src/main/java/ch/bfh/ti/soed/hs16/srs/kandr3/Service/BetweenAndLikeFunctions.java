package ch.bfh.ti.soed.hs16.srs.kandr3.Service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ch.bfh.ti.soed.hs16.srs.kandr3.Model.Resource;

public class BetweenAndLikeFunctions {
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      EntityManager entitymanager = emfactory.createEntityManager();
      
      //Between
      Query query = entitymanager.createQuery( "Select r " + "from Resource r " + "where r.size " + "Between 30000 and 40000" );
      
      List<Resource> list=(List<Resource>)query.getResultList( );

      for( Resource r:list ){
         System.out.print("Resource ID :" + r.getEid( ));
         System.out.println("\t Resource size :" + r.getSize( ));
      }

      //Like
      Query query1 = entitymanager.createQuery("Select r " + "from Resource r " + "where r.description LIKE 'M%'");
      
      List<Resource> list1=(List<Resource>)query1.getResultList( );
      
      for( Resource r:list1 ) {
         System.out.print("Resource ID :"+r.getEid( ));
         System.out.println("\t Resource description :"+r.getDescription( ));
      }
   }
}