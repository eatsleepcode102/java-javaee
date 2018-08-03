package designpatterns.creational_patterns.abstract_factory;

public class PC extends Computer {

	private String ram;
	private String hdd;
	
	@Override
	String getRam() {
		// TODO Auto-generated method stub
		return this.ram;
	}

	@Override
	String getHdd() {
		// TODO Auto-generated method stub
		return this.hdd;
	}

	public PC(String ram, String hdd) {
		super();
		this.ram = ram;
		this.hdd = hdd;
	}
}
