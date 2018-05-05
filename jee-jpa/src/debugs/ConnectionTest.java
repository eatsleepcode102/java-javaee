package debugs;

import java.io.Console;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Country;

public class ConnectionTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2s_jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Country country=em.createQuery("select c from Country c where c.countryId=:country_id", Country.class).setParameter("country_id", 2).getSingleResult();
		System.out.println(country.getCountry());
		country.getCities().forEach(ci->{
			System.out.println(ci.getCity());
		});
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
