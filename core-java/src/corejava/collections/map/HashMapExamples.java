package corejava.collections.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
* 1. Java HashMap allows null key and null values.
* 2. HashMap is not an ordered collection. You can iterate over HashMap entries through keys set but they are not guaranteed to be in the order of their addition to the HashMap.
* 3. HashMap is almost similar to Hashtable except that it’s unsynchronized and allows null key and values.
* 4. HashMap uses it’s inner class Node<K,V> for storing map entries.
* 5. HashMap stores entries into multiple singly linked lists, called buckets or bins. Default number of bins is 16 and it’s always power of 2.
* 6. HashMap uses hashCode() and equals() methods on keys for get and put operations. So HashMap key object should provide good implementation of these methods. This is the reason immutable classes are better suitable for keys, for example String and Interger.
* 7. Java HashMap is not thread safe, for multithreaded environment you should use ConcurrentHashMap class or get synchronized map using Collections.synchronizedMap() method.
*/


public class HashMapExamples {

	public static void main(String[] args) {
		Map<String, String> map=new HashMap<>();
		map.put("1", "1"); //put example
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", null);// null value
		map.put(null, "100");// null key
		
		String value=map.get("3");
		System.out.println("Key =3, Value= "+value);
		
		value= map.getOrDefault("5", "Default Value");
		System.out.println("Key =5, Value="+ value);
		
		boolean keyExists=map.containsKey(null);
		boolean valueExists=map.containsValue("100");
		
		System.out.println("keyExists="+ keyExists+", valueExists="+ valueExists);

		Set<Entry<String, String>> entrySet=map.entrySet();
		System.out.println("entry set="+ entrySet);
		
		System.out.println("map size="+map.size());
		
		Map<String,String> map1=new HashMap<>();
		map1.putAll(map);
		System.out.println("map1 mappings= "+map1);
		
		String nullKeyValue=map1.remove(null);
		System.out.println("map1 null key value="+nullKeyValue);
		System.out.println("map1 after removing null key="+map1);
		
		Set<String> keySet=map.keySet();
		System.out.println("map keys="+ keySet);
		
		Collection<String> values=map.values();
		System.out.println("map values= "+ values);
		
		map.clear();
		System.out.println("map is empty="+ map.isEmpty());
	}

}
