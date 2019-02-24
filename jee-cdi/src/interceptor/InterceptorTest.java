package interceptor;

import org.jboss.weld.environment.se.Weld;

import interceptor.GreetingBean;

public class InterceptorTest {

	public static void main(String[] args) {
		GreetingBean bean=new Weld().initialize().instance().select(GreetingBean.class).get();
		System.out.println(bean.isConstructed());
		System.out.println(bean.getParam().getValue());

	}

}
