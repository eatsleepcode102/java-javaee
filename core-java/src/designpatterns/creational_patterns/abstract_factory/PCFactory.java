package designpatterns.creational_patterns.abstract_factory;

public class PCFactory implements AbtractComputerFactory{

	private String ram;
	private String hdd;
	
	
	
	public PCFactory(String ram, String hdd) {
		super();
		this.ram = ram;
		this.hdd = hdd;
	}

	@Override
	public Computer createComputer() {
		// TODO Auto-generated method stub
		return new PC(this.ram, this.hdd);
	}

}
