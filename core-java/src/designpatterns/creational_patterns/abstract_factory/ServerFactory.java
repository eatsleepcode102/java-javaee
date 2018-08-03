package designpatterns.creational_patterns.abstract_factory;

public class ServerFactory implements AbtractComputerFactory{

	private String ram;
	private String hdd;
	
	
	
	public ServerFactory(String ram, String hdd) {
		super();
		this.ram = ram;
		this.hdd = hdd;
	}

	@Override
	public Computer createComputer() {
		// TODO Auto-generated method stub
		return new Server(this.ram, this.hdd);
	}

}
