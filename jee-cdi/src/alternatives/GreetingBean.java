package alternatives;

import javax.inject.Inject;

public class GreetingBean {

	@Inject
	@SimpleGreet
	Greeting greeting;

	public Greeting getGreeting() {
		return greeting;
	}
}
