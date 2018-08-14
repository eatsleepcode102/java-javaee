package corejava.common.access_modifiers.one;

public class Person {
	public String name;
	private String secret;
	
	public Person(String name) {
		this.name=name;
	}
	
	public void showSecret(){
		System.out.println("Secret: "+this.secret); //we can access from internal class
	}
	
	class Diary {
		public void logging(){
			System.out.println("Secret: "+ secret); // access from inner class
		}
	}
}

