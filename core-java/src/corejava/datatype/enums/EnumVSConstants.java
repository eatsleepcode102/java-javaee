package corejava.datatype.enums;

public class EnumVSConstants {

	public static void main(String[] args) {
		//there are 2 risks with using constant
		//1. we can pass any int constant to the method (> 5), so it is not safe
		//2. when pass a value that is greater than 5 there is no error come out while compiling time

	}
	
	private static void simpleEnumExample(ThreadStates th) {
		if(th == ThreadStates.START) System.out.println("Thread started");
		else if (th == ThreadStates.WAITING) System.out.println("Thread is waiting");
		else if (th == ThreadStates.RUNNING) System.out.println("Thread is running");
		else System.out.println("Thread is dead");
	}
	
	private static void simpleConstantsExample(int i) {
		if(i == ThreadStatesConstant.START) System.out.println("Thread started");
		else if (i == ThreadStatesConstant.WAITING) System.out.println("Thread is waiting");
		else if (i == ThreadStatesConstant.RUNNING) System.out.println("Thread is running");
		else System.out.println("Thread is dead");
	}

}

enum ThreadStates {
	START, RUNNING, WAITING, DEAD;
}

class ThreadStatesConstant {
	public static final int START =1;
	public static final int WAITING=2;
	public static final int RUNNING =3;
	public static final int DEAD=4;
}