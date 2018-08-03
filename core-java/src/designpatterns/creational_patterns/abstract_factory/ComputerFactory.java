package designpatterns.creational_patterns.abstract_factory;

public class ComputerFactory {
	public static Computer getComputer(AbtractComputerFactory factory){
		return factory.createComputer();
	}
}
