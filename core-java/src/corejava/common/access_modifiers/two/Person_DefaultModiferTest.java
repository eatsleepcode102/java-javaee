package corejava.common.access_modifiers.two;

import corejava.common.access_modifiers.one.DefaultPerson;

public class Person_DefaultModiferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultPerson de=new DefaultPerson();
//		de.showMe();// not be allowed
//		de.getInfo();// not be allowed
		
	}

}

class childDefaultPerson extends DefaultPerson{
	public void test(){
//		this.showMe(); //not be allowed
		this.showMe(); // in case be subclasses, we can allow to access after changing access-modifier of the function to protected
	}
}