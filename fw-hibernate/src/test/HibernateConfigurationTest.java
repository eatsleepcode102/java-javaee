package test;

import java.util.Date;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import utils.HibernateUtil;


public class HibernateConfigurationTest {

	public static void main(String[] args) throws InterruptedException {
		Employee emp = new Employee();
//		emp.setName("Saver");
//		emp.setRole("Dev");
//		emp.setInsertTime(new Date());
		
		//Get Session
		Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		
		emp=session.get(Employee.class, 1);
		session.delete(emp);// after calling delete method emp is not persist
		
//		session.evict(emp);// emp is not in persistent context
//		emp.setRole("GGG");
//		session.merge(emp);// a object is loaded and then merge the new value(GGG) of emp and then execute update
//		emp.setRole("FFF");// emp is still detached state so has no change in database on this action

		
		session.getTransaction().commit();

		
		System.out.println("Employee ID="+emp.getId());
		
	}
}