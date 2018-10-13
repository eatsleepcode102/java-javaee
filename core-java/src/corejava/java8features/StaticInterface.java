package corejava.java8features;

public class StaticInterface {

	public static void main(String[] args) {
		MyDataImpl obj = new MyDataImpl();
		obj.print("");
		obj.isNull("abc");
		MyData.isNull("adf");

	}

}

interface MyData {
	default void print(String str) {
		if (!isNull(str)) {
			System.out.println("MyData Print::" + str);
		}
	}
	
	//if we change static keyword to default then it will not be called anymore 
	//because we overrode it already and the interface static method is visible to interface method only
	static boolean isNull(String str) {
		System.out.println("Interface Null Check");
		return str == null ? true : "".equals(str) ? true : false;
	}
}

class MyDataImpl implements MyData {
	public boolean isNull(String str) {
		System.out.println("Impl null check");
		return str == null ? true : false;
	}
}