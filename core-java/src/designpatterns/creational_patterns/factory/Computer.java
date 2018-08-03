package designpatterns.creational_patterns.factory;

public abstract class Computer {
	abstract String getRam();
	abstract String getHdd();
	
	@Override
	public String toString() {
		return "info: Ram="+getRam()+" GB, Hdd="+getHdd()+" GB";
	}
}
