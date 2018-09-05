package test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

import entities.Student;

public class ConfigurationTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dvdrental_unit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
//		Employee emp = new Employee();
//		emp.setName("Pankaj");
//		emp.setRole("CEO");
//		emp.setInsertTime(new Date());
//		em.persist(emp);
//		Session session=em.unwrap(Session.class);
//		Employee emp= session.get(Employee.class, 5);
//		emp.setRole("CEO");
//		session.save(emp);
		
		int maxValue=em.createQuery("select max(s.student_id) from Student s", Integer.class).getSingleResult();
		System.out.println(maxValue);
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
