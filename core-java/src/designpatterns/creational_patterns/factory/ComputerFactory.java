package designpatterns.creational_patterns.factory;

public class ComputerFactory {
	
	public static Computer createFactory(String type, String ram, String hdd){
		if("PC".equals(type)){
			return new PC(ram,hdd);
		} else if("Server".equals(type)){
			return new Server(ram, hdd);
		} else return null;
	}
}
