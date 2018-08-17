package alternatives;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

//@Alternative // we only use @Alternative when we specify beans in beans.xml
@FancyGreet
public class FancyGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return "Nice to meet you, hello" + name;
    }

}
