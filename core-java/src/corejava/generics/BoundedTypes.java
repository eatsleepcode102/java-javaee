package corejava.generics;
/**
 * Establishing an upper bound for a wildcard
 * <? extends superclass>
 * Specifying a lower bound for a wildcard
 * <? super subclass>
 * Here is the syntax for a generic method:
 * <type-param-list> return-type meth-name(param-list)
 * ex. public <T extends Number, K extends Number> cal(T t);
 * */


public class BoundedTypes {

	public static void main(String[] args) {
		Integer[] inums={1,2,3,4,5};
		Stats<Integer> iob=new Stats(inums);
		System.out.println("iob average is "+ iob.average());

	}
}

class Stats<T extends Number> {
	T[] nums;
	
	public Stats(T[] o) {
		nums=o;
	}
	double average(){
		double sum=0;
		for (T t : nums) {
			sum+=t.doubleValue();
		}
		return sum/nums.length;
	}
}