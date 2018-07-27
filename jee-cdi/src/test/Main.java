package test;

import org.jboss.weld.environment.se.Weld;

public class Main {

	public static void main(String[] args) {
		GreetingBean bean=new Weld().initialize().instance().select(GreetingBean.class).get();
		System.out.println(bean.getGreeting().greet("Jonanthan"));
	}
}
