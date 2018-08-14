package designpatterns.structural_patterns;

public class BridgeTest {

	public static void main(String[] args) {
		Shape circle=new Circle(new ColorPrinter());
		circle.draw();
	}
}

abstract class Shape {

	protected Printer printer;

	protected Shape(Printer p) {
		this.printer = p;
	}
	abstract void draw();
}

class Circle extends Shape {

	public Circle(Printer p) {
		super(p);
	}

	@Override
	public void draw() {
		// use outer action
		printer.print();
	}

}

interface Printer {
	void print();
}

class ColorPrinter implements Printer {

	@Override
	public void print() {
		System.out.println("Color: printing something");

	}
}

class BlackPrinter implements Printer {

	@Override
	public void print() {
		System.out.println("Black: printing something");

	}
}
