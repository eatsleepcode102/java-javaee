package corejava.generics;

import java.util.List;

public class GenericsType {

	public static void main(String[] args) {
		GenericsTypeOld type = new GenericsTypeOld();
		type.setT("Andrew");
		String str = (String) type.getT();//// type casting, error prone and can
											//// cause ClassCastException
		System.out.println(str);

		GenericsTypeNew<String> newType = new GenericsTypeNew<>();
		newType.setT("Pankaj"); // valid

		GenericsTypeNew newType1 = new GenericsTypeNew(); // raw type
		newType1.setT("Pankaj"); // valid
		newType1.setT(10); // valid and autoboxing support

		// Generics method
		GenericsTypeNew<String> g1 = new GenericsTypeNew<>();
		g1.setT("Pankaj");
		GenericsTypeNew<String> g2 = new GenericsTypeNew<>();
		g2.setT("Pankaj");
		boolean isEqual = GenericsMethods.<String>isEqual(g1, g2);
		// above statement can be written simply as
		isEqual = GenericsMethods.isEqual(g1, g2);
		// This feature, known as type inference, allows you to invoke a generic
		// method as an ordinary method, without specifying a type between angle
		// brackets.
		// Compiler will infer the type that is needed
		
		//Generic and inheritance
		str = "abc";
		Object obj = new Object();
		obj=str; // works because String is-a Object, inheritance in java
		
		GenericsTypeNew<String> myClass1 = new GenericsTypeNew<String>();
		GenericsTypeNew<Object> myClass2 = new GenericsTypeNew<Object>();
		//myClass2=myClass1; // compilation error since MyClass<String> is not a MyClass<Object>
		obj = myClass1; // MyClass<T> parent is Object
		
		

	}
	
	public static double sum(List<? extends Number> list){
		double sum = 0;
		for(Number n : list){
			sum += n.doubleValue();
		}
		return sum;
	}
	
	public static void addIntegers(List<? super Integer> list){
		list.add(new Integer(50));
	}
}

class GenericsTypeOld {
	private Object t;

	public Object getT() {
		return t;
	}

	public void setT(Object t) {
		this.t = t;
	}
}

class GenericsTypeNew<A> {
	private A t;

	public A getT() {
		return t;
	}

	public void setT(A t) {
		this.t = t;
	}
}

interface MyComparable<T> {
	public int compareTo(T o);
	public static <T extends Comparable<T>> int compare(T t1, T t2){
		return t1.compareTo(t2);
	}
}

class GenericsMethods {
	public static <T> boolean isEqual(GenericsTypeNew<T> g1, GenericsTypeNew<T> g2) {
		return g1.getT().equals(g2.getT());
	}
}