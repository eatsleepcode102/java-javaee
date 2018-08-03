package designpatterns.creational_patterns.abstract_factory;

public abstract class Computer {
	abstract String getRam();
	abstract String getHdd();
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+": RAM="+getRam()+", HDD="+getHdd();
	}
	
	
}
