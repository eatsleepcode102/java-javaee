package vetoed;

import javax.inject.Inject;

public class GreetingBean {

	@Inject
	Greeting greeting;

	public Greeting getGreeting() {
		return greeting;
	}
}
