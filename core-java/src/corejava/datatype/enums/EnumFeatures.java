package corejava.datatype.enums;

import java.io.Closeable;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

/**
 * 1. all java enum implicitly extends Enumm class that extends Object class and implements Serializable and Comparable interfaces, so we can't extend any class in enum
 * 2. name package "enum" is invalid
 * 3. enum constructors are always private
 * 4. we can't create instance of enum using new operator
 * 5. we can declare abstract method in java enum, then all the enum fields must implement the abstract method
 * 6. we cam define a method in enum and enum fields can override them too
 * 7. Java enum fields has namespace, we can use enum field only with class name like ThreadStates.START
 * 8. Enum constants are implicitly static and final, we can compare them using "==" and equals()
 * 
 * */

public class EnumFeatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		usingEnumSet();
		usingEnumMap();
	}

	private static void usingEnumSet() {
		EnumSet enumSet = EnumSet.allOf(ThreadStatesEnum.class);
		enumSet.forEach(tsenum ->{
			System.out.println("Using EnumSet, priority = "+((ThreadStatesEnum) tsenum).getPriority());

		});
	}
	
	private static void usingEnumMap() {
		EnumMap<ThreadStatesEnum, String> enumMap = new EnumMap<ThreadStatesEnum,String>(ThreadStatesEnum.class);
		enumMap.put(ThreadStatesEnum.START, "Thread is started");
		enumMap.put(ThreadStatesEnum.RUNNING, "Thread is running");
		enumMap.put(ThreadStatesEnum.WAITING, "Thread is waiting");
		enumMap.put(ThreadStatesEnum.DEAD, "Thread is dead");
		
		Set keySet = enumMap.keySet();
		keySet.forEach(key ->{
			System.out.println("key="+key.toString()+":: value="+enumMap.get(key));
		});
	}
	
	private static void usingEnumInSwitch(ThreadStatesEnum th) {
		switch (th){
		case START:
			System.out.println("START thread");
			break;
		case WAITING:
			System.out.println("WAITING thread");
			break;
		case RUNNING:
			System.out.println("RUNNING thread");
			break;
		case DEAD:
			System.out.println("DEAD thread");
		}
	}
	
	private static void usingEnumValues() {
		ThreadStatesEnum[] thArray = ThreadStatesEnum.values();
		
		for(ThreadStatesEnum th : thArray){
			System.out.println(th.toString() + "::priority="+th.getPriority());
		}
	}
	
	public static void usingEnumValueOf(){
		ThreadStatesEnum th=Enum.valueOf(ThreadStatesEnum.class, "START");
		System.out.println("th priority="+th.getPriority());
	}
	
	private static void usingEnumMethods() throws IOException {
		ThreadStatesEnum thc = ThreadStatesEnum.DEAD;
		System.out.println("priority is:"+thc.getPriority());
		
		thc = ThreadStatesEnum.DEAD;
		System.out.println("Using overriden method."+thc.toString());
		
		thc = ThreadStatesEnum.START;
		System.out.println("Using overriden method."+thc.toString());
		thc.setPriority(10);
		System.out.println("Enum Constant variable changed priority value="+thc.getPriority());
		thc.close();
	}
}

enum ThreadStatesEnum implements Closeable {
	START(1){
		@Override
		public String getDetail() {
			return "START";
		}
	},
	RUNNING(2){
		@Override
		public String getDetail() {
			return "RUNNING";
		}
	},
	WAITING(3){
		@Override
		public String getDetail() {
			return "WAITING";
		}
	},
	DEAD(4){
		@Override
		public String getDetail() {
			return "DEAD";
		}
	}
	;

	private int priority;
	
	//Enum can have methods
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public abstract String getDetail();
	
	//Enum constructors should always be private.
		private ThreadStatesEnum(int i){
			priority = i;
		}


	@Override
	public String toString() {
		return "Default ThreadStatesConstructors implementation. Priority="+getPriority();
	}
	
	////Enum can override functions
	@Override
	public void close() throws IOException {
		System.out.println("Close of Enum");
	}
	
}
