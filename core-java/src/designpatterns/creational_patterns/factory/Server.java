package designpatterns.creational_patterns.factory;

public class Server extends Computer {

	private String ram;
	private String hdd;
	
	public Server(String ram, String hdd) {
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
