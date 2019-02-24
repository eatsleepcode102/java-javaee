package corejava.thread;

public class ThreadLocalExample {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * the ThreadLocal class in Java enables you to create variables that can only
		 * be read and written by the same thread. Thus even if two threads are executing the same code and the code has a reference to a ThreadLocal variable
		 * then the two threads cannot see each others's ThreadLocal variables
		 * 
		 * */
		ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				threadLocal.set((int) (Math.random() * 100D));
				try {
					Thread.sleep(12);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(threadLocal.get());
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				threadLocal.set((int) (Math.random() * 100D));
				try {
					Thread.sleep(12);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(threadLocal.get());
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
	}

}
