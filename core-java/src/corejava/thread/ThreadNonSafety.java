package corejava.thread;

public class ThreadNonSafety {

	public static void main(String[] args) {
		ProcessingThread pt=new ProcessingThread();
		Thread t1=new Thread(pt,"t1");
		t1.start();
		Thread t2=new Thread(pt,"t2");
		t2.start();
		//wait for threads to finish processing
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Processing count="+pt.getCount());

	}

}

class ProcessingThread implements Runnable {

	private int count;
	
	@Override
	public void run() {
		for(int i=1; i<5;i++) {
			count++;
			try {
				Thread.sleep(i*100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getCount() {
		return this.count;
	}
}