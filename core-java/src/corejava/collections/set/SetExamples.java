package corejava.collections.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetExamples {
	public static void main(String[] args) {

		System.out.println("______________Array to Set________");
		String[] vowels = { "a", "e", "i", "o", "u" };
		Set<String> vowelsSet = new HashSet<>(Arrays.asList(vowels));
		System.out.println(vowelsSet);

		/**
		 * Unlike List, Set is NOt backed by array, so we can do structural
		 * modification without any issues.
		 */
		vowelsSet.remove("e");
		System.out.println(vowelsSet);
		vowelsSet.clear();
		System.out.println(vowelsSet);

		System.out.println("_________HashSet contructor_________");
		Set<String> set = new HashSet<>();
		// initial capacity should be power of 2
		set = new HashSet<>(16);
		set = new HashSet<>(16, 0.85f);// load factor is set default 0.75, this
										// is good for most . take note: if 16x
										// 0.75=12
		// -> current nums 2^4= 16 will be jumped into next size 2^5=32 when
		// 13th item putted
		set = new HashSet<>(Arrays.asList(vowels));
		System.out.println(set.size());

		System.out.println("________Hashset methods_______");
		Set<String> fruits = new HashSet<>();
		// add example
		fruits.add("Apple");
		fruits.add("Banana");
		// isEmpty example
		System.out.println("fruits set is empty=" + fruits.isEmpty());
		// contain example
		System.out.println("fruits contains Apple=" + fruits.contains("Apple"));
		System.out.println("fruits contains Mango=" + fruits.contains("Mango"));
		// remove example
		System.out.println("Apple removed from fruits set=" + fruits.remove("Apple"));
		;
		System.out.println("Mango removed from fruits set=" + fruits.remove("Mango"));
		// size example
		System.out.println("fruits set size=" + fruits.size());
		// addAll example
		List<String> list = new ArrayList<>();
		list.add("Apple");
		list.add("Apple");
		list.add("Banana");
		list.add("Mango");

		System.out.println("fruits set before addAll = " + fruits);
		System.out.println("list = " + list);
		fruits.addAll(list);
		System.out.println("fruits set after addAll = " + fruits);

		// iterator example
		Iterator<String> iterator = fruits.iterator();
		while (iterator.hasNext()) {
			String fruit=iterator.next();
			System.out.println("Consuming fruit " +  fruit);
			//wrong way can throw ConcurrentModificationException
			if("Mango".equals(fruit)) //fruits.remove("Mango");
			//correct way
			iterator.remove();
		}

		// removeAll example
		fruits.add("Orange");
		System.out.println("fruits set before removeAll = " + fruits);
		System.out.println("list = " + list);
		fruits.removeAll(list);
		System.out.println("fruits set after removeAll = " + fruits);

		// clear example
		fruits.clear();
		System.out.println("fruits set is empty = " + fruits.isEmpty());
		
		System.out.println("________Array to HashSet and vice versa_______");
		Set<Integer> ints=new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		System.out.println("ints set="+ints);
		//set to array example
		Integer[] intArray=new Integer[ints.size()];
		intArray=ints.toArray(intArray);
		System.out.println("intArray="+Arrays.toString(intArray));
		ints.remove(1);
		ints.remove(2);
		System.out.println("intArray="+Arrays.toString(intArray));
		
	}
}