package designpatterns.structural_patterns;

public class DecoratorTest {

	public static void main(String[] args) {
		Car basicCar=new BasicCar();
		// now decorate the basic Car
		Car car=new LuxuryCar(new SportCar(basicCar));
		car.essemble();
	}
}

interface Car {
	void essemble();
}

class BasicCar implements Car {
	@Override
	public void essemble() {
		System.out.println("Basic Car");
		
	}
}

class CarDecorator implements Car {
	protected Car car;
	
	public CarDecorator(Car car) {
		this.car = car;
	}

	@Override
	public void essemble() {
		this.car.essemble();
	}
}

//will have many class (new features) extending CarDecorator
class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car car) {
		super(car);
	}

	@Override
	public void essemble() {
		System.out.println("adding luxury's feature");
		super.essemble();
	}
}

class SportCar extends CarDecorator {

	public SportCar(Car car) {
		super(car);
	}

	@Override
	public void essemble() {
		System.out.println("adding sport's feature");
		addingRocket();
		super.essemble();
	}
	
	//extend new functionality by adding a state or behavior
	public void addingRocket(){
		System.out.println("adding a rocket in rear");
	}
	
}