package corejava.java8features;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachExample {

	public static void main(String[] args) {
		List<Integer> myList=new ArrayList<Integer>();
		for(int i=0; i< 10 ; i++) {
			myList.add(i);
		}
		
		System.out.println("traverse list by using Iterator");
		Iterator<Integer> it=myList.iterator();
		while(it.hasNext()) {
			Integer i=it.next();
			System.out.println("Iterator value:"+i);
		}
		//traversing through forEach method of Iterable with anonymous clas
		System.out.println("traverse list by using forEach");
		myList.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println("forEach anonymous class value:"+t);
			}
		});
		//traversing with Consumer interface implementation
		MyConsumer action= new MyConsumer();
		myList.forEach(action);
	}

}

//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>{

	@Override
	public void accept(Integer t) {
		System.out.println("Comsumer Impl value::"+t);
	}
	
}
