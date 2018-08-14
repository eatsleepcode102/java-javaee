package corejava.common.access_modifiers.one;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person tom=new Person("Tom");
		String name=tom.name;
//		String secret=tom.secret; //don't allow to access
		
		DefaultPerson de=new DefaultPerson();
		de.showMe();// be allowed
		de.getInfo(); // be allowed
	}

}
