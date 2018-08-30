package relation_mapping;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Student;
import entity.Subjects;


public class OneToManyTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dvdrental_unit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

//		Integer nextValue=em.createQuery("select max(s.student_id) from Student s", Integer.class).getSingleResult();
//		nextValue=nextValue==null? 1: nextValue+1;
//		Student st=new Student(nextValue);
//		st.setName("Andrew");
//		st.setRemarks("Food");
//		em.persist(st);
//		
//		Integer nextValue1=em.createQuery("Select max(e.pk.subject_id) from Subjects e where e.pk.stu_id=:stu_id", Integer.class).setParameter("stu_id", st.getStudent_id()).getSingleResult();
//		nextValue1=nextValue1==null? 1: nextValue1+1;
//		Subjects su=new Subjects(new Subjects.Pk(nextValue1, st.getStudent_id()));
//		su.setSubject_name("Math");
////		em.persist(su);
//		st.getSubjects().add(su);
//		em.flush();
		
		Student st=em.find(Student.class, 2);
		em.remove(st);
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
