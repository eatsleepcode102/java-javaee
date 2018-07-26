package examples;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import entities.Country;
import entities.Country_;

public class OptimisticExamples {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dvdrental_unit");
		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
		
		Country c=getCountryById(em, 109);
		updateCountry(em, c, "Zambia l1");
		updateCountry(em, c, "Zambia l2");
		
//		em.getTransaction().commit();
		em.close();
		emf.close();

	}
	
	public static Country getCountryById(EntityManager em, int id){
		CriteriaBuilder builder=em.getCriteriaBuilder();
		CriteriaQuery<Country> criteria=builder.createQuery(Country.class);
		Root<Country> root=criteria.from(Country.class);
		criteria.where(builder.equal(root.get(Country_.countryId), id));
		TypedQuery<Country> query=em.createQuery(criteria);
		return query.getSingleResult();
	}
	
	public static void updateCountry(EntityManager em,Country c, String newStr){
		em.getTransaction().begin();
		em.lock(c, LockModeType.OPTIMISTIC);
		c.setCountry(newStr);
		em.getTransaction().commit();
	}
}

