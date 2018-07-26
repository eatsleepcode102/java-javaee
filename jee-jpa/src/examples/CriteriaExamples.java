package examples;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import entities.Country;
import entities.Country_;

public class CriteriaExamples {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dvdrental_unit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		listCountries(em);
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}
	
	public static void listCountries(EntityManager em){
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
	}
	
	public static void updateCountry(EntityManager em){
		CriteriaBuilder builder=em.getCriteriaBuilder();
		CriteriaUpdate<Country> updateCriteria=builder.createCriteriaUpdate(Country.class);
		Root<Country> updateRoot=updateCriteria.from(Country.class);
		updateCriteria.set(updateRoot.get(Country_.country), "Zambia1");
		updateCriteria.where(builder.equal(updateRoot.get(Country_.countryId), 109));
		em.createQuery(updateCriteria).executeUpdate();
		em.flush();
	}
	
	public static void deleteCountry(EntityManager em){
		CriteriaBuilder builder=em.getCriteriaBuilder();
		CriteriaDelete<Country> deleteCriteria=builder.createCriteriaDelete(Country.class);
		Root<Country> deleteRoot=deleteCriteria.from(Country.class);
		deleteCriteria.where(builder.equal(deleteRoot.get(Country_.country), "Zambia1"));
		em.createQuery(deleteCriteria).executeUpdate();
		em.flush();
	}

}
