package corejava.collections.map;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * 1. Java HashMap allows null key and null values. 2. HashMap is not an ordered
 * collection. You can iterate over HashMap entries through keys set but they
 * are not guaranteed to be in the order of their addition to the HashMap. 3.
 * HashMap is almost similar to Hashtable except that it’s unsynchronized and
 * allows null key and values. 4. HashMap uses it’s inner class Node<K,V> for
 * storing map entries. 5. HashMap stores entries into multiple singly linked
 * lists, called buckets or bins. Default number of bins is 16 and it’s always
 * power of 2. 6. HashMap uses hashCode() and equals() methods on keys for get
 * and put operations. So HashMap key object should provide good implementation
 * of these methods. This is the reason immutable classes are better suitable
 * for keys, for example String and Interger. 7. Java HashMap is not thread
 * safe, for multithreaded environment you should use ConcurrentHashMap class or
 * get synchronized map using Collections.synchronizedMap() method.
 */

public class HashMapExamples {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("1", "1"); // put example
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", null);// null value
		map.put(null, "100");// null key

		String value = map.get("3");
		System.out.println("Key =3, Value= " + value);

		value = map.getOrDefault("5", "Default Value");
		System.out.println("Key =5, Value=" + value);

		boolean keyExists = map.containsKey(null);
		boolean valueExists = map.containsValue("100");

		System.out.println("keyExists=" + keyExists + ", valueExists=" + valueExists);

		Set<Entry<String, String>> entrySet = map.entrySet();
		System.out.println("entry set=" + entrySet);

		System.out.println("map size=" + map.size());

		Map<String, String> map1 = new HashMap<>();
		map1.putAll(map);
		System.out.println("map1 mappings= " + map1);

		String nullKeyValue = map1.remove(null);
		System.out.println("map1 null key value=" + nullKeyValue);
		System.out.println("map1 after removing null key=" + map1);

		Set<String> keySet = map.keySet();
		System.out.println("map keys=" + keySet);

		Collection<String> values = map.values();
		System.out.println("map values= " + values);

		map.clear();
		System.out.println("map is empty=" + map.isEmpty());

		System.out.println("_________________ keySet");
		Map<String, String> map2 = new HashMap<>();
		map2.put("1", "1");
		map2.put("2", "2");
		map2.put("3", "3");
		Set<String> keySet2 = map2.keySet();
		System.out.println(keySet2);
		map2.put("4", "4");
		System.out.println(keySet2);// keySet is backed by Map
		keySet2.remove("1");
		System.out.println(map2);// map is also modified
		keySet2 = new HashSet<>(map2.keySet());
		map2.put("5", "5");
		System.out.println(keySet2);// keyset2 is not modified

		System.out.println("_________________ values");
		Map<String, String> map3 = new HashMap<>();
		map3.put("1", "1");
		map3.put("2", "2");
		map3.put("3", null);
		map3.put("4", null);
		map3.put(null, "100");
		Collection<String> values3 = map3.values();
		System.out.println("map values=" + values3);
		map3.remove(null);
		System.out.println("map values after removing null key = " + values3);
		map3.put("5", "5");
		System.out.println("map values after put = " + values3);
		System.out.println(map3);
		values3.remove("1"); // changing values collection
		System.out.println(map3); // updates in map too

		System.out.println("_________________ entrySet");
		Map<String, String> map4 = new HashMap<>();
		map4.put("1", "1");
		map4.put("2", null);
		map4.put(null, "100");
		Set<Entry<String, String>> entrySet4 = map4.entrySet();
		Iterator<Entry<String, String>> iterator = entrySet4.iterator();
		Entry<String, String> next = null;
		System.out.println("map before processing = " + map4);
		System.out.println("entrySet before processing = " + entrySet4);
		while (iterator.hasNext()) {
			next = iterator.next();
			System.out.println("processing on:" + next.getValue());
			if (next.getKey() == null)
				iterator.remove();
		}
		System.out.println("map after processing = " + map4);
		System.out.println("entrySet after processing = " + entrySet4);

		Entry<String, String> simpleEntry = new AbstractMap.SimpleEntry<String, String>("1", "1");
		entrySet4.remove(simpleEntry);
		System.out.println("map after removing Entry = " + map4);
		System.out.println("entrySet after removing Entry = " + entrySet4);

		System.out.println("_________________ forEach");
		Map<String, String> map5 = new HashMap<>();
		map5.put("1", "1");
		map5.put("2", null);
		map5.put(null, "100");
		BiConsumer<String, String> action = new MyBiConsumer();
		map5.forEach(action);
		// lambda expression example
		System.out.println("\nHashMap forEach lambda example\n");
		map5.forEach((k, v) -> {
			System.out.println("Key= " + k + ", value=" + v);
		});

		System.out.println("_________________ replaceAll");
		Map<String, String> map6 = new HashMap<>();
		map6.put("1", "1");
		map6.put("2", "2");
		map6.put(null, "100");
		System.out.println("map before replaceAll = " + map6);
		BiFunction<String, String, String> function = new MyBiFunction();
		map6.replaceAll(function);
		System.out.println("map after replaceAll = " + map6);
		// replaceAll using lambda expressions
		map6.replaceAll((k, v) -> {
			if (k != null)
				return k + v;
			else
				return v;
		});
		System.out.println("map after replaceAll lambda expression = " + map6);
	}

}

class MyBiConsumer implements BiConsumer<String, String> {

	@Override
	public void accept(String t, String u) {
		System.out.println("Key =" + t);
		System.out.println("processing on value=" + u);

	}
}

class MyBiFunction implements BiFunction<String, String, String> {

	@Override
	public String apply(String t, String u) {
		if (t != null) {
			return t + u;
		} else {
			return u;
		}
	}

}
