package corejava.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsBasic {

	public static void main(String[] args) {
		// #1 Life without Generics
		List string = new ArrayList();
		string.add("Java 5");
		string.add("with generics");
		String s1 = (String) string.get(0);// we get an instance of object,
											// although we added a String
		System.out.println(s1);// to get original type of the instance we need
								// to downcast to target type

		// #2 What Are Generics? A Simple Generics Example
		// Create a Gen reference for Integers.
		GenergicClass<Integer> iOb = new GenergicClass(88);
		iOb.showType();
		// no cast is needed
		int v = iOb.getOb();
		System.out.println("value:" + v);

		// create a Gen object for String
		GenergicClass<String> strOb = new GenergicClass("generics Test");
		strOb.showType();
		String str = strOb.getOb();
		System.out.println("value: " + str);

		// #3 Generics Work Only with Objects
		// Gen<int> strOb = new Gen<int>(53); // Error, can't use primitive type

		// #4 A Generic Class with Two Type Parameters
		TwoGen<Integer, String> tgOb=new TwoGen(88, "Andrew");
		tgOb.showTypes();
		int tOb = tgOb.getob1();
	    System.out.println("value: " + tOb);

	    String vOb = tgOb.getob2();
	    System.out.println("value: " + vOb);
	    
//	    #5 Nested generic type
	    List<String> listOfStrings = new ArrayList<String>();
	    listOfStrings.add("Hello again");
	    List<List<String>> listOfLists = new ArrayList<List<String>>();
	    listOfLists.add(listOfStrings);
	    String s = listOfLists.get(0).get(0);
	    System.out.println(s); // prints "Hello again"
	}

}

class GenergicClass<T> {
	T ob;

	public GenergicClass(T ob) {
		super();
		this.ob = ob;
	}

	T getOb() {
		return ob;
	}

	void showType() {
		System.out.println("Type of T is " + ob.getClass().getName());
	}
}

class TwoGen<T, V> {
	T ob1;
	V ob2;

	public TwoGen(T ob1, V ob2) {
		super();
		this.ob1 = ob1;
		this.ob2 = ob2;
	}

	void showTypes() {
		System.out.println("Type of T is " + ob1.getClass().getName());

		System.out.println("Type of V is " + ob2.getClass().getName());
	}

	T getob1() {
		return ob1;
	}

	V getob2() {
		return ob2;
	}
}