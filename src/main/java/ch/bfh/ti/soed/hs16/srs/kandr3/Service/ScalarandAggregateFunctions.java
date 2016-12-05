package ch.bfh.ti.soed.hs16.srs.kandr3.Service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ScalarandAggregateFunctions {
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      EntityManager entitymanager = emfactory.createEntityManager();

      //Scalar function
      Query query = entitymanager.
      createQuery("Select UPPER(r.description) from Resource r");
      List<String> list = query.getResultList();

      for(String r:list) {
         System.out.println("Resource DESCRIPTION :"+r);
      }
      
      //Aggregate function
      Query query1 = entitymanager.createQuery("Select MAX(r.size) from Resource r");
      Double result = (Double) query1.getSingleResult();
      System.out.println("Max Resource Size :" + result);
   }
}