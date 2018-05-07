package examples;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import entities.Country;
import entities.Country_;

public class CriteriaExamples {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dvdrental_unit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		CriteriaBuilder builder=em.getCriteriaBuilder();
		CriteriaQuery<Country> listCriteria=builder.createQuery(Country.class);
		Root<Country> listRoot=listCriteria.from(Country.class);
		listCriteria.select(listRoot);
		listCriteria.where(builder.or(builder.equal(listRoot.get(Country_.countryId), 2),builder.equal(listRoot.get(Country_.countryId), 3)));
		TypedQuery<Country> query=em.createQuery(listCriteria);
		List<Country> results=query.getResultList();
		
		results.stream().forEach(r->{
			System.out.println(r.getCountry());
		});
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
