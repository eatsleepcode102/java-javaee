package corejava.language;

public class AbstractAndInterface {

	public static void main(String[] args) {
		SoftWareBean bean=new SoftWareBean();
		NiceTester niceTester =new NiceTester();
		Developer dev=new Developer();
		bean.doCoding(dev);
		System.out.println("coding... [done]");
		bean.doTesting(niceTester);
	}
}

class SoftWareBean {
	
	public void doCoding(Codable coder) {
		coder.code();
	}
	
	public void doTesting(Testable tester) {
		tester.test();
	}
}

class NiceTester extends Person implements Testable, Singable {

	@Override
	public void sing() {
		System.out.println("Nice Tester is singing");
	}

	@Override
	public void test() {
		System.out.println("Nice Tester is testing");
	}

	@Override
	public void eat() {
		System.out.println("Nice Tester is eating");
	}

	@Override
	public void sleep() {
		System.out.println("Nice Tester is sleeping");
	}
	
}

class Singer extends Person implements Singable, Danceable{

	@Override
	public void eat() {
		System.out.println("Singer is eating");
	}

	@Override
	public void sleep() {
		System.out.println("Singer is sleeping");
	}

	@Override
	public void sing() {
		System.out.println("Singer is singing");
	}

	@Override
	public void dance() {
		System.out.println("Singer is dancing");
	}
	
}

class Developer extends Person implements Codable {

	@Override
	public void code() {
		System.out.println("Developer is coding");
	}

	@Override
	public void eat() {
		System.out.println("Developer is eating");
	}

	@Override
	public void sleep() {
		System.out.println("Developer is sleeping");
	}
	
}

abstract class Person {
	public abstract void eat();
	public abstract void sleep();
}

interface Codable {
	void code();
}

interface Testable {
	void test();
}

interface Singable {
	void sing();
}

interface Danceable {
	void dance();
}
	