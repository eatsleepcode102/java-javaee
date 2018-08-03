package designpatterns.creational_patterns.factory;

public class PC extends Computer {

	private String ram;
	private String hdd;
	
	public PC(String ram, String hdd) {
		this.ram=ram;
		this.hdd=hdd;
	}
	
	@Override
	String getRam() {
		return this.ram;
	}

	@Override
	String getHdd() {
		return this.hdd;
	}

}
