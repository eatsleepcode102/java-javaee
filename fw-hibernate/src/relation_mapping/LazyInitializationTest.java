package relation_mapping;

import org.hibernate.Session;

import entities.Student;
import entities.Subjects;
import utils.HibernateUtil;

public class LazyInitializationTest {

	public static void main(String[] args) {
		//Get Session
				Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
				//start transaction
				session.beginTransaction();
				
				Student stu=session.get(Student.class, 1);
				System.out.println(stu.getName());
				for(Subjects sub: stu.getSubjects()){
					System.out.println(sub.getSubject_name());
				}

				
				session.getTransaction().commit();

	}

}
