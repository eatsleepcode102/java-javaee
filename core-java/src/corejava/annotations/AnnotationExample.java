package corejava.annotations;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AnnotationExample {
	
	public static void main(String[] args) throws FileNotFoundException {
		AnnotationExample.genericsTest();
	}
	
	@MethodInfo(author="Andrew", comments="Main method", date="30/08/2018", revision=1)
	@Override
	public String toString() {
		return "Overriden toString method";
	}
	
	@Deprecated
	@MethodInfo(author="Katy", comments="deprecated method" , date="6/1/2018")
	public static void oldMethod(){
		System.out.println("old method, done use it");
	}
	
	@SuppressWarnings("unchecked")
	@MethodInfo(author = "Pankaj", comments = "Main method", date = "Nov 17 2012", revision = 10)
	public static void genericsTest() throws FileNotFoundException {
		List l = new ArrayList();
		l.add("abc");
		oldMethod();
	}
}
