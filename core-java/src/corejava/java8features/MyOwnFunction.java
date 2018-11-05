package corejava.java8features;


public class MyOwnFunction {
	public static void main(String[] args) {
		MyFunction<Integer, String> func=(i)-> {
			System.out.println("precessing....");
			return Integer.toString(i);
		};
		System.out.println(func.apply(5));
	}
}


@FunctionalInterface
interface MyFunction<T, R> {
	R apply(T t);
}
