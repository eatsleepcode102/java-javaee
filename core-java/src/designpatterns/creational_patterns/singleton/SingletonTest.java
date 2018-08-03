package designpatterns.creational_patterns.singleton;

public class SingletonTest {

	public static void main(String[] args) {
		Singleton.getIntance().doSomething();

	}

}

class Singleton {
	private static Singleton instance;

	private Singleton() {
		// Private constructor to restrict instantiation of the class from other
		// classes.
	}

	public static synchronized Singleton getIntance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public void doSomething() {
		System.out.println("the instance :: some actions");
	}
}