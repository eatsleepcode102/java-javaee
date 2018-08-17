package decorators;

import org.jboss.weld.environment.se.Weld;

public class DecoratorsTest {

	public static void main(String[] args) {
		GreetingBean bean=new Weld().initialize().instance().select(GreetingBean.class).get();
		System.out.println(bean.getGreeting().greet("Andrew"));

	}

}
