package corejava.generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class GenergicsMethod {

	public static void main(String[] args) {
		Integer nums[] = { 1, 2, 3, 4, 5 };

		if (isIn(2, nums)) {
			System.out.println("2 is in nums");
		}
		if (!isIn(7, nums)) {
			System.out.println("7 is not in nums");
		}

		String strs[] = { "one", "two", "three", "four", "five" };
		if (isIn("two", strs)) {
			System.out.println("two is in strs");
		}
		if (!isIn("seven", strs)) {
			System.out.println("two is not in strs");
		}

		// #2 genergic constructors
		GenergicClass1 test = new GenergicClass1(100);
		GenergicClass1 test2 = new GenergicClass1(123.5f);
		test.showValue();
		test2.showValue();

		// #3 max
		Collection<String> strings = Arrays.asList("AAA", "aaa", "CCC", "f");
		System.out.println(MyComparators.max(strings));

		System.out.printf("Maximum of %d, %d and %d is %d\n", 3, 4, 5, maximum(3, 4, 5));
		System.out.printf("Maximum of %s, %s and %s is %s\n", "pear", "apple", "orange",
				maximum("pear", "apple", "orange"));
	}

	// #1 Creating a Generic Method
	static <T, V extends T> boolean isIn(T x, V[] y) {
		for (int i = 0; i < y.length; i++) {
			if (x.equals(y[i])) {
				return true;
			}
		}
		return false;
	}

	// #4 Generic method maximum returns the largest of three objects
	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x;
		if (y.compareTo(max) > 0) {
			max = y;
		}
		if (z.compareTo(max) > 0) {
			max = z;
		}
		return max;
	}
}

class GenergicClass1 {
	private double val;

	public <T extends Number> GenergicClass1(T arg) {
		val = arg.doubleValue();
	}

	void showValue() {
		System.out.println("val: " + val);
	}
}

class MyComparators {
	public static <T> T max(Collection<? extends T> coll, Comparator<? super T> cmp) {
		T candidate = coll.iterator().next();
		for (T elt : coll) {
			if (cmp.compare(candidate, elt) < 0) {
				return candidate = elt;
			}
		}
		return null;
	}

	public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll) {
		return max(coll, Comparator.<T>naturalOrder());
	}
}
