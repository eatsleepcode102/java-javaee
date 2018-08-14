package corejava.common.access_modifiers.one;

public class DefaultPerson {
	protected void showMe(){
		System.out.println("Im a person with default access modifier");
	}
	
	static String getInfo(){
		return "Default Person";
	}
}