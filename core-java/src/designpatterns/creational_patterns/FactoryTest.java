package designpatterns.creational_patterns;

public class FactoryTest {

	public static void main(String[] args) {
		Computer1 pc=ComputerFactory1.createFactory("PC", "3", "500");
		System.out.println("PC "+pc);
	}
}

abstract class Computer1 {
	abstract String getRam();
	abstract String getHdd();
	
	@Override
	public String toString() {
		return "info: Ram="+getRam()+" GB, Hdd="+getHdd()+" GB";
	}
}

class PC1 extends Computer1 {

	private String ram;
	private String hdd;
	
	public PC1(String ram, String hdd) {
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

class Server1 extends Computer1 {

	private String ram;
	private String hdd;
	
	public Server1(String ram, String hdd) {
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

class ComputerFactory1 {
	
	public static Computer1 createFactory(String type, String ram, String hdd){
		if("PC".equals(type)){
			return new PC1(ram,hdd);
		} else if("Server".equals(type)){
			return new Server1(ram, hdd);
		} else return null;
	}
}
