package crud;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import entities.Survey;
import utils.HibernateJDBCUtil;

public class SaveTest {

	public static void main(String[] args) throws Exception {
		HibernateJDBCUtil hibernateUtil=new HibernateJDBCUtil();
		
		Session session = hibernateUtil.getSession();
//		
//		Survey survey = new Survey();
//		survey.setId(1);
//	    survey.setName("Zin");
//	    survey.setPurchaseDate(new Date());
//
//	    session.save(survey);
//	    session.flush();
	    
	    Criteria crit=session.createCriteria(Survey.class);
//	    crit.setProjection(Projections.rowCount()); // return number of records
	    crit.setProjection(Projections.distinct(Projections.property("id")));
	    List results = crit.list();
	    System.out.println(results);
		
	    session.close();
	    hibernateUtil.checkData("select * from survey");

	}

}
