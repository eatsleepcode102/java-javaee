package alternatives_priority;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;

@Priority(2)
@Alternative
public class PriorityGreeting implements Greeting {

	@Override
	public String greet(String name) {
		// TODO Auto-generated method stub
		return "hey "+name+" this should be selected since I've got the highest priority!";
	}
}
