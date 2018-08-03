package designpatterns.creational_patterns.factory;

public class FactoryTest {

	public static void main(String[] args) {
		Computer pc=ComputerFactory.createFactory("PC", "3", "500");
		System.out.println("PC "+pc);

	}

}
