package corejava.java8features;

import java.util.function.Function;

public class IsFunctionalOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Integer, Integer> func=s-> s+3;
	}

}

interface Foo {
	boolean equals(Object obj);
}
// Not functional because equals is already an implicit member (Object class)

interface Comparator<T> {
	boolean equals(Object obj);

	int compare(T o1, T o2);
}
// Functional because Comparator has only one abstract non-Object method

interface Foo0 {
	int m();

	Object clone();
}
// Not functional because method Object.clone is not public

interface X {
	int m(Iterable<String> arg);
}

interface Y {
	int m(Iterable<String> arg);
}

interface Z extends X, Y {
}
// Functional: two methods, but they have the same signature

interface X3 {
	Iterable m(Iterable<String> arg);
}

interface Y3 {
	Iterable<String> m(Iterable arg);
}

interface Z3 extends X3, Y3 {
}
// Functional: Y.m is a subsignature & return-type-substitutable

interface X2 {
	int m(Iterable<String> arg);
}

interface Y2 {
	int m(Iterable<Integer> arg);
}

//interface Z2 extends X2, Y2 {
//}
// Not functional: No method has a subsignature of all abstract methods

interface X0 {
	int m(Iterable<String> arg, Class c);
}

interface Y0 {
	int m(Iterable arg, Class<?> c);
}

//interface Z0 extends X0, Y0 {
//}
// Not functional: No method has a subsignature of all abstract methods

interface X1 {
	long m();
}

interface Y1 {
	int m();
}

//interface Z1 extends X1, Y1 {
//}
// Compiler error: no method is return type substitutable

interface Foo1<T> {
	void m(T arg);
}

interface Bar1<T> {
	void m(T arg);
}

//interface FooBar1<X, Y> extends Foo1<X>, Bar1<Y> {
//}
// Compiler error: different signatures, same erasure