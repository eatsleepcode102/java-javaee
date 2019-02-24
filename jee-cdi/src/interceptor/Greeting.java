package interceptor;

/**
 * @author Radim Hanus
 */
public interface Greeting {
    boolean isConstructed();

    boolean isInitialized();

    Param getParam();
}
