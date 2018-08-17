package alternatives_priority;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GreetingBean {

	@Inject
	Greeting greeting;

	public Greeting getGreeting() {
		return greeting;
	}
	
	
}
