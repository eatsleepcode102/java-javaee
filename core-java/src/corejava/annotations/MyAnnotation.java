package corejava.annotations;

/*
 * All annotation types automatically extend the Annotation interface.
Annotation is a super-interface of all annotations.
It overrides hashCode( ), equals( ), and toString() defined by Object.
It defines annotationType( ), which returns a Class object that represents the invoking annotation.
When you apply an annotation, you give values to its members.
 * 
 * */

public @interface MyAnnotation {//Adding '@' before the keyword interface to declare an annotation type.
	//All annotations consist only method declarations.
	String stringValue();//These methods act much like fields.
	int intValue();
}
