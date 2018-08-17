package alternatives;

import javax.enterprise.inject.Alternative;

//@Alternative // we only use @Alternative when we specify beans in beans.xml
@SimpleGreet
public class SimpleGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return "Hello " + name;
    }
}