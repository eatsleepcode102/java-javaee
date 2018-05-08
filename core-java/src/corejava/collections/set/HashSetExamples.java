package corejava.collections.set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HashSetExamples {

	public static void main(String[] args) {
//		Unlike List, We cannot convert a Java Set into an array directly as it’s NOT implemented using an Array.
//		So We cannot use Arrays class to get the view of array as set. We can follow another approach.
//		We can convert an array into List using Arrays.asList() method, then use it to create a Set.
//		By using this approach, we can covert a Java Array to Set in two ways. Let us discuss them one by one using one simple example.
		
		System.out.println("____Array to Set_____");
//		approach-1
		String[] vowels = {"a","e","i","o","u"};
		Set<String> vowelsSet=new HashSet<>(Arrays.asList(vowels));
//		approach-2
		vowelsSet = new HashSet<>();
		Collections.addAll(vowelsSet, vowels); 
		System.out.println(vowelsSet);
		// convert Set to Array
		String strArray[] =vowelsSet.toArray(new String[vowelsSet.size()]);
		System.out.println("set to array:"+Arrays.toString(strArray));
		/**
		 * Unlike List, Set is NOt backed by array, 
		 * so we can do structural modification without any issues.
		 */
		vowelsSet.remove("e");
		System.out.println(vowelsSet);
		vowelsSet.clear();
		System.out.println(vowelsSet);
	}

}
