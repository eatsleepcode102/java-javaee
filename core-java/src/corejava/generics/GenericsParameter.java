package corejava.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GenericsParameter {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
        list1.add ("Hello");
        list1.add ("World");
        printList (list1);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(100);
        list2.add(200);
        printList(list2);
        
        List<Integer> intList=Arrays.asList(3, 30, 300);
        System.out.println(getAverage(intList));
        
//        #3 Multiple Type Parameters
        Pair<Integer, String> p=new Pair<Integer, String>(1,"A");
        System.out.println(p.getKey().getClass().getName());
	}
	
//	#1 Using the ? wildcard
	public static void printList(List<?> list){
		for (Object object : list) {
			System.out.println(object);
		}
	}
	
//	#2  Using Bounded Wildcards in Methods
	public static double getAverage(List<? extends Number> numberList){
		double total=0;
		for (Number number : numberList) {
			total+=number.doubleValue();
		}
		return total/numberList.size();
	}
	
//	#4 Constraints on a Wildcard
	public static void saveAll(LinkedList<? extends Serializable> list){}
	public static void analyze(LinkedList<? super String> list){};
}


class Pair<KeyType, ValueType> {
	
	private KeyType key;
	private ValueType value;
	
	public KeyType getKey() {
		return key;
	}

	public void setKey(KeyType key) {
		this.key = key;
	}

	public ValueType getValue() {
		return value;
	}

	public void setValue(ValueType value) {
		this.value = value;
	}

	public Pair(KeyType aKey, ValueType aValue){
		key=aKey;
		value=aValue;
	}
}