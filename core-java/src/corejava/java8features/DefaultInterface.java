package corejava.java8features;

public class DefaultInterface {

	public static void main(String[] args) {
		MyClass my = new MyClass();
		my.log("andrew");
	}

}

interface Interface1 {
	void method1(String str);

	default void log(String str) {
		System.out.println("I1 logging::" + str);
	}
}

interface interface2 {
	void method2();

	default void log(String str) {
		System.out.println("I2 logging::" + str);
	}
}

class MyClass implements Interface1, interface2 {

	@Override
	public void method2() {
		// TODO Auto-generated method stub

	}

	@Override
	public void method1(String str) {
		// TODO Auto-generated method stub

	}

	// we can see that overriding method1 and method 2 is mandatory
	// the complier will force us to provide implementation for log()
	@Override
	public void log(String str) {
		// TODO Auto-generated method stub
		Interface1.super.log(str);
		System.out.println("MyClass logging::" + str);
	}

}