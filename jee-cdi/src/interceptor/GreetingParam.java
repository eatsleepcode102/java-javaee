package interceptor;

/**
 * @author Radim Hanus
 */
public class GreetingParam implements Param {
    private String value;

    public GreetingParam() {
        value = "Greeting";
    }

    @Override
    public String getValue() {
        return value;
    }
}
