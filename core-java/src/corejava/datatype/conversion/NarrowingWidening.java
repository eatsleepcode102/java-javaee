package corejava.datatype.conversion;

/**
 * The widening conversion is permitted in the following cases:
byte to short, int, long, float, or double
Short to int, long, float, or double
char to int, long, float, or double
int to long, float, or double
long to float or double
float to double
 * 
 * In general, the narrowing primitive conversion can occur in these cases:

short to byte or char
char to byte or short
int to byte, short, or char
long to byte, short, or char
float to byte, short, char, int, or long
double to byte, short, char, int, long, or float
The narrowing primitive conversion must be explicit.
You need to specify the target type in parentheses.
 * */
public class NarrowingWidening {

	public static void main(String[] args) {
		long a = 9876543210L;
	    int b = (int) a;

	    System.out.println(b); //there is some information loss because 9876543210L is too big for an int.
	    
	    String sValue = "5";

	    try {
	      int iValue = new Integer(sValue).intValue();
	      System.out.println(iValue);
	    } catch (NumberFormatException ex) {
	      ex.printStackTrace();
	    }
	    
	    Integer intObj = new Integer(10);
	    
	    String str = intObj.toString();
	    System.out.println("Integer converted to String as " + str);
	    
	    String s = "123";
	    int number = Integer.parseInt(s);
	    
	    convertStringToInt();
	}
	
	public static void convertStringToInt() throws NumberFormatException {

	    String s = "123";
	    int number = Integer.parseInt(s);
	    System.out.println(number);

	  }

}
