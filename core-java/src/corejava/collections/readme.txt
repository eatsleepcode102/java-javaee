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