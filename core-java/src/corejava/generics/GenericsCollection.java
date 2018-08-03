package corejava.generics;

import java.util.Arrays;

public class GenericsCollection {

	public static void main(String[] args) {
		// #1 Using Generic Comparable interface
		Person[] authors = { new Person("D", "S"), new Person("J", "G"), new Person("T", "C"), new Person("C", "S"),
				new Person("P", "C"), new Person("B", "B") };

		Arrays.sort(authors); // sort using comparable method
		System.out.println("\n order after sorting into ascending sequence:");
		for (Person author : authors) {
			System.out.println(author);
		}

		Person[] people = { new Person("C", "S"), new Person("N", "K"), new Person("T", "C"), new Person("C", "D") };
		int index = 0;
		System.out.println("\n In search of authors:");
		for (Person person : people) {
			index = Arrays.binarySearch(authors, person);
			if (index >= 0) {
				System.out.println(person + " was found at index position " + index);
			} else {
				System.out.println(person + "was not found. Return value is " + index);
			}
		}
	}

}

class Person implements Comparable<Person> {
	private String firstName;
	private String surName;

	public Person(String firstName, String surName) {
		this.firstName = firstName;
		this.surName = surName;
	}

	@Override
	public String toString() {
		return firstName + " " + surName;
	}

	@Override
	public int compareTo(Person o) {
		int result = this.surName.compareTo(o.surName);
		return result == 0 ? this.firstName.compareTo(o.firstName) : result;
	}
}
