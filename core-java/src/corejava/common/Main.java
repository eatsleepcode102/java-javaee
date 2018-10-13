package corejava.common;
//author
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Submain m=new Submain();
		m.main(123);
	}
	
	public static void main(Integer arg){
		System.out.println("arg="+ arg);
	}

}

class Submain extends Main {
	
	public static void main(Integer arg) {
		Main.main(arg);
		System.out.println("sub arg ="+ arg);
	}
}
