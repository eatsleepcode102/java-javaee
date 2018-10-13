package corejava.language;

public class AnonymousClassExample {
	public static void main(String[] args) {
		A a=new A() {

			@Override
			public void print() {
				System.out.println("A::print");
			}

			@Override
			public void say() {
				System.out.println("A::say");
			}
			
		};
		a.print();
	}
}

interface A {
	public void print();
	public void say();
	
}