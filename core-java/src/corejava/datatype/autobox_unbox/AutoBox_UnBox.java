package corejava.datatype.autobox_unbox;

public class AutoBox_UnBox {

	public static void main(String[] args) {
		Integer integer=1;
		System.out.println(integer);//int into Integer
		int i=integer+3;// mix Integer and ints
		System.out.println(i);
		/*
		 * boxing refers to the conversion of a primitive to a corresponding wrapper instance
		 * such as from an int to a Integer
		 * unboxing is the conversion of a wrapper instance to a primitive type
		 * such as from Byte to byte 
		 * */
		Integer number=new Integer(100);
		int [] ints =new int[2];
		ints[0]=number;
		//below is manually boxing
		Integer iOb=new Integer(100);
		int n=iOb.intValue();
	}
}
