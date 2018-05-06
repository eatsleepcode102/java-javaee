package debugs;

import java.io.Console;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ConnectionTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dvdrental_unit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		String query="select a.countryId, a.country, b.cityId from Country a inner join City b where a.countryId=:country_id";
		List<Object[]> country=em.createQuery(query).setParameter("country_id", 2).getResultList();

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
