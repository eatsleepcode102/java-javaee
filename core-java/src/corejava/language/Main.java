package corejava.language;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Submain m=new Submain();
		m.main(123);
		
		actionListener(new MyListener() {
			@Override
			public void run() {
				System.out.println("define run method()");
			}
		});
	}
	
	public static void main(Integer arg){
		System.out.println("arg="+ arg);
	}

	public static void actionListener(MyListener listener) {
		listener.run();
	}
}

class Submain extends Main {
	
	public static void main(Integer arg) {
		Main.main(arg);
		System.out.println("sub arg ="+ arg);
	}
}

interface MyListener {
	void run();
}
