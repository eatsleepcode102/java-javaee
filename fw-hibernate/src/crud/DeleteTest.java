package crud;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.Survey;
import utils.HibernateJDBCUtil;

public class DeleteTest {

	public static void main(String[] args) throws Exception {
		HibernateJDBCUtil hibernateUtil=new HibernateJDBCUtil();
//		hibernateUtil
//        .executeSQLCommand("create table survey (id int,name varchar, purchasedate date);");
		
		Session session = hibernateUtil.getSession();
		
//		Survey survey = new Survey();
//		survey.setId(1);
//	    survey.setName("Survey");
//	    survey.setPurchaseDate(new Date());
//
//	    session.save(survey);
//
//	    
//	    survey = new Survey();
//	    survey.setId(2);
//	    survey.setName("Survey1");
//	    survey.setPurchaseDate(new Date());    
//	    session.save(survey);
//	    
//	    session.flush();
	    
		Query query =session.createQuery("delete from Survey where name=:name");
		query.setString("name", "Survey1");
		System.out.println("Rows effected:"+query.executeUpdate());
		
	    session.close();
	    hibernateUtil.checkData("select * from survey");
	}

}
