package corejava.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPoolExample {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newFixedThreadPool(5);
		for(int i=0; i < 10; i++) {
			Runnable worker=new WorkerThread(""+i);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
//			System.out.println("processing...");
		}
		System.out.println("Finished all threads");

	}
}

class WorkerThread implements Runnable {
	
	private String command;
	
	public WorkerThread(String s) {
		this.command=s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"Start. Command ="+ command);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String toString() {
		return this.command;
	}
	
}
