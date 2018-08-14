package designpatterns.behavioral_patterns;

public class TemplateTest {

	public static void main(String[] args) {
		HouseTemplate house=new WoodenHouse();
		house.buildHouse();
	}
}


abstract class HouseTemplate {

	public void buildHouse() {
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("your house is built");
	}
	
	private void buildFoundation(){
		System.out.println("building foundation with cement, iron rods and sand");
	}
	public abstract void buildPillars();
	public abstract void buildWalls();
	
	private void buildWindows(){
		System.out.println("building Windows");
	}
}

class WoodenHouse extends HouseTemplate {

	@Override
	public void buildPillars() {
		System.out.println("building pillars with wood coating");
	}

	@Override
	public void buildWalls() {
		System.out.println("building wooden walls");
	}
	
}

class GlassHouse extends HouseTemplate {

	@Override
	public void buildPillars() {
		System.out.println("building pillars with glass coating");
	}

	@Override
	public void buildWalls() {
		System.out.println("building glass walls");
	}
	
}