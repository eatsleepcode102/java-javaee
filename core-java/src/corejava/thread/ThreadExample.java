package corejava.thread;

public class ThreadExample {

	public static void main(String[] args) {
		//if your class provides more functionality rather than just running as a thread you should implement Runnable
		Thread runThreadByPassingRunnableObject = new Thread(new HeavyWorkRunnable(), "implementing Runnable");
		runThreadByPassingRunnableObject.start();
		
		//if your class is only to run as a thread then you can extend Thread class
		HeavyWorkThread runThreadByUsingThreadObject =new HeavyWorkThread("extending Thread");
		runThreadByUsingThreadObject.run();
	}

}

class HeavyWorkRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Doing heavy processing - START:" + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);

			doDBProcessing();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void doDBProcessing() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("process DB- DONE");
	}
}

class HeavyWorkThread extends Thread {

	public HeavyWorkThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println("MyThread - START: " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
			doDBProcessing();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("MyThread - END " + Thread.currentThread().getName());
	}

	private void doDBProcessing() throws InterruptedException {
		Thread.sleep(5000);
	}

}