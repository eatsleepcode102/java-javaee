package designpatterns.creational_patterns;

public class AbstractFactoryTest {

	public static void main(String[] args) {
		Computer pc=ComputerFactory.getComputer(new PCFactory("2 GB", "1024 MB"));
		System.out.println(pc);
		
		Computer server=ComputerFactory.getComputer(new ServerFactory("20 GB", "750 GB"));
		System.out.println(server);
	}

}

class ComputerFactory {
	public static Computer getComputer(AbtractComputerFactory factory){
		return factory.createComputer();
	}
}

interface AbtractComputerFactory {
	public Computer createComputer();
}

class PCFactory implements AbtractComputerFactory{

	private String ram;
	private String hdd;
	
	
	
	public PCFactory(String ram, String hdd) {
		super();
		this.ram = ram;
		this.hdd = hdd;
	}

	@Override
	public Computer createComputer() {
		return new PC(this.ram, this.hdd);
	}

}

class ServerFactory implements AbtractComputerFactory{

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


abstract class Computer {
	abstract String getRam();
	abstract String getHdd();
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+": RAM="+getRam()+", HDD="+getHdd();
	}
}

class PC extends Computer {

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

class Server extends Computer {

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

	public Server(String ram, String hdd) {
		super();
		this.ram = ram;
		this.hdd = hdd;
	}
}

