package corejava.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class LambdaExpression {

	public static void main(String[] args) {
		System.out.println("is 23 a prime?-" + isPrime(23));
		IntPredicate predicate = i -> i % 2 == 0;
		System.out.println("sum of all even numbers from 1 to 10:" + sumWithCondition(10, predicate));
		System.out.println(
				"the square of max odd number in list:" + findSquareOfMaxOdd(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));

	}

	public static boolean isPrime(Integer number) {
		return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
	}

	public static long sumWithCondition(Integer number, IntPredicate predicate) {
		return IntStream.range(1, number).filter(predicate).mapToLong(i -> i).sum();
	}

	public static int findSquareOfMaxOdd(List<Integer> numbers) {
		return numbers.stream().filter(NumberUtils::isOdd).filter(NumberUtils::isGreaterThan3)
				.filter(NumberUtils::isLessThan11).max(Comparator.naturalOrder()).map(i -> i * i).get();
	}

}

class NumberUtils {
	// predicates
	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}

	public static boolean isGreaterThan3(int i) {
		return i > 3;
	}

	public static boolean isLessThan11(int i) {
		return i < 11;
	}
}

@FunctionalInterface
interface Processor {
	public void getStringLength(Function<String,Integer> func);
}
