package test;

import java.util.Date;

import org.hibernate.Session;

import utils.HibernateJDBCUtil;

public class JDBCConfigurationTest {

	public static void main(String[] args) throws Exception {
		HibernateJDBCUtil hibernateUtil=new HibernateJDBCUtil();
		Session session = hibernateUtil.getSession();
		
//		Employee emp=new Employee();
//		emp.setId(1);
//		emp.setName("Andrew");
//		emp.setRole("Dev");
//		session.save(emp);
//		session.flush();
		
		Employee empInSession = (Employee) session.get(Employee.class, 5);
		empInSession.setInsertTime(new Date());
		session.flush();
		System.out.println(empInSession);
		session.close();
		
		hibernateUtil.checkData("select * from Employee");

	}

}
