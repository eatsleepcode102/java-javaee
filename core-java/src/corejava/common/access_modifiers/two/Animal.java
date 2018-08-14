package corejava.common.access_modifiers.two;

public class Animal {
	
	protected void move(){
		System.out.println("Animal move");
	}
}

class Cat extends Animal {

	@Override
	public void move() {
		super.move();
	}
	
}

class Dog extends Animal {

//	@Override
//	 void move() { // can not be private or default
//		super.move();
//	}
}