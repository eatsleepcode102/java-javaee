package examples;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utils.TabularFormatBuilder;

public class JoiningMultipleTables {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dvdrental_unit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// ex1
		/**
		 * @nativeQuery 
		 * select a.country_id, a.country, b.city from country a
		 *              inner join city b on a.country_id= b.country_id where
		 *              a.country_id='2' order by a.country_id;
		 */
		String innerJoinQuery = "select a.countryId, a.country, b.city from Country a inner join a.cities b where a.countryId=:country_id";
		List<Object[]> results = em.createQuery(innerJoinQuery).setParameter("country_id", 2).getResultList();
		TabularFormatBuilder.instance()
	    .setColumnLengths(10,15,20)
	    .setColumnNames("country id", "country", "city")
	    .setData(results)
	    .build();

		// ex2
		/**
		 * @nativeQuery 
		 * SELECT customer.customer_id, customer.first_name
		 *              customer_first_name, customer.last_name
		 *              customer_last_name, customer.email, staff.first_name
		 *              staff_first_name, staff.last_name staff_last_name,
		 *              amount, payment_date FROM customer INNER JOIN payment ON
		 *              payment.customer_id = customer.customer_id INNER JOIN
		 *              staff ON payment.staff_id = staff.staff_id  WHERE customer.customer_id='2';
		 */
		String query1 = "select c.customerId, c.firstName, c.lastName, c.email, s.firstName, s.lastName, p.amount, p.paymentDate"
				+ " from Customer c join c.payments p join p.staff s where c.customerId=:country_id";
		List<Object[]> results1=em.createQuery(query1).setParameter("country_id", 2).getResultList();
	    TabularFormatBuilder.instance()
	    .setColumnLengths(10, 15,15,40,15,15,10,20)
	    .setColumnNames("c.customerId", "c.firstName", "c.lastName", "c.email", "s.firstName","s.lastName", "p.amount","p.paymentDate")
	    .setData(results1)
	    .build();
	    
	    
		em.getTransaction().commit();
		em.close();
		emf.close();

	}
}
