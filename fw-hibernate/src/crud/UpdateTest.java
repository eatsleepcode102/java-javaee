package crud;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.Survey;
import utils.HibernateJDBCUtil;

public class UpdateTest {

	public static void main(String[] args) throws Exception {
		HibernateJDBCUtil hibernateUtil = new HibernateJDBCUtil();
		Session session = hibernateUtil.getSession();

		// Survey sur=new Survey();
		// sur.setId(1);
		// sur.setName("Andrew");
		// sur.setPurchaseDate(new Date());
		// session.save(sur);
		// session.flush();
		// session.close();

//		 Survey sur=session.load(Survey.class, 1);// we can not execute this query
		// because we did not define primary key of the survey table
		
//		Query query = session.createQuery("select a from Survey a where a.id=:id");
//		query.setInteger("id", 1);
//		List<Survey> result = query.list();
//		Survey sur = !result.isEmpty() ? result.get(0) : null;
//
//		if (sur != null) {
//			sur.setName("Heiwei");
//			session.flush();
//		}
		
		Query q=session.createQuery("update Survey a set a.name='Jum' where a.id=:id");
		q.setInteger("id", 1);
		q.executeUpdate();
		session.close();

		hibernateUtil.checkData("select * from survey");
	}

}
