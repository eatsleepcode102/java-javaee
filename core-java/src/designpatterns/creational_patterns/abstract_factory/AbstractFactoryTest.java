package designpatterns.creational_patterns.abstract_factory;

public class AbstractFactoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer pc=ComputerFactory.getComputer(new PCFactory("2 GB", "1024 MB"));
		System.out.println(pc);
		
		Computer server=ComputerFactory.getComputer(new ServerFactory("20 GB", "750 GB"));
		System.out.println(server);
	}

}
