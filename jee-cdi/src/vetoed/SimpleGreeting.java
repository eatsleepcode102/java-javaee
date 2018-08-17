package vetoed;

import javax.enterprise.inject.Vetoed;

@Vetoed// not in use
public class SimpleGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return "Hello " + name;
    }

}