package alternatives_priority;

import org.jboss.weld.environment.se.Weld;

public class AlternativesPriorityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreetingBean bean=new Weld().initialize().instance().select(GreetingBean.class).get();
		System.out.println(bean.getGreeting().greet("Andrew"));
	}
}
