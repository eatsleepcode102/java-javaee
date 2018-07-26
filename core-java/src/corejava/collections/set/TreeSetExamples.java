package corejava.collections.set;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetExamples {
	
	public static void main(String[] args) {
//		Java TreeSet elements are ordered as per their natural ordering or we can provide a Comparator while creating SortedSet.
//		If we don’t provide specific Comparator during set creation, elements must implement the Comparable to ensure natural ordering.
		SortedSet<Integer> setWithNaturalOrdering=new TreeSet<Integer>();
		setWithNaturalOrdering.add(5);
		setWithNaturalOrdering.add(8);
		setWithNaturalOrdering.add(2);
		setWithNaturalOrdering.add(6);
		setWithNaturalOrdering.forEach(System.out::println);
		
		// Create a sorted set with user defined class
		SortedSet<Person> sortedSet = new TreeSet<>();
		sortedSet.add(new Person(1, "Mark"));
		sortedSet.add(new Person(2, "Vispi"));
		sortedSet.add(new Person(3, "Harmony"));
//		sortedSet.forEach(System.out::println);
		
		//we can alse provide instance of Comparator implementation instead of lambda
		SortedSet<Person> customOrderedSet=new TreeSet<>((p1, p2)-> p1.id- p2.id);
		customOrderedSet.addAll(sortedSet);
//		customOrderedSet.forEach(System.out::println);
		
		//We can also create sorted set by passing another collection object or a different sorted set.
		List<Person> listOfPerson = Arrays.asList(new Person(1, "Mark"), new Person(2, "Vispi"), new Person(3, "Harmony"));
		SortedSet<Person> sortedSetFromCollection = new TreeSet<>(listOfPerson);
		SortedSet<Person> copiedSet = new TreeSet<>(sortedSetFromCollection);
		copiedSet.forEach(System.out::println);
		
//		Java SortedSet Implementation
		SortedSet<Integer> intSet = new TreeSet<>(Comparator.naturalOrder());
		intSet.addAll(Arrays.asList(9,7,4,3,1,6));
		Comparator comparator = intSet.comparator();
		intSet.forEach(System.out::print);
		SortedSet<Integer> subSet = intSet.subSet(1, 7);
		System.out.println(subSet);
		subSet.add(3);
		System.out.println(intSet);
		subSet = intSet.headSet(2);
		System.out.println("Head set");
		System.out.println(subSet);

		subSet = intSet.tailSet(2);
		System.out.println("Tail set");
		System.out.println(subSet);

		System.out.println("Retrieving lowest and highest elements respectively");
		System.out.println(intSet.first());
		System.out.println(intSet.last());
	}
}


class Person implements Comparable<Person>{
	
	int id;
	String name;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}