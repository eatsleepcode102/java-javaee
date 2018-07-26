Java collection framework consists of following parts:
- interface: 
	+ java.util.Collection is a interface on the top of Collections framework hierarchy.
	+ It contains some important method such as size(), iterator(), add(), remove(), clear() that every Collection class must implement.
	+ some other important interfaces are java.util.List, java.util.Set, java.util.Queue, java.util.Map, but Map is only interface that doesn't
	inherit from Collection interface
- implementation classes: 
- Algorithms: algorithms are useful methods to provide some common functionalities

+ Set Interface
Set is a collection that cannot contain duplicate elements. This interface models the mathematical set abstraction and is used to represent sets, such as the deck of cards.
The Java platform contains three general-purpose Set implementations: HashSet, TreeSet, and LinkedHashSet. Set interface doesn’t allow random-access to an element in the Collection. You can use iterator or foreach loop to traverse the elements of a Set.
Java Set interface is a member of the Java Collections Framework.
Unlike List, Set DOES NOT allow you to add duplicate elements.
Set allows you to add at most one null element only.
Set interface got one default method in Java 8: spliterator.
Unlike List and arrays, Set does NOT support indexes or positions of it’s elements.
Set supports Generics and we should use it whenever possible. Using Generics with Set will avoid ClassCastException at runtime.
We can use Set interface implementations to maintain unique elements.

+Map
Map provides three collection views – set of keys, set of key-value mappings and collection of values.
Map doesn’t guarantee order of mappings, however it depends on the implementation. For example, HashMap doesn’t guarantee the order of mappings but TreeMap does.
Map utilise hashCode and equals methods on Key for get and put operations. So mutable classes are not a good fit for Map keys. If the values of hashCode or equals change after put, you won’t get the correct value in get operation.
Popular implementation classes of Map in Java are HashMap, Hashtable, TreeMap, ConcurrentHashMap and LinkedHashMap.
AbstractMap class provides skeletal implementation of the Map interface, most of the Map concrete classes extend AbstractMap class and implement required methods.


