package corejava.thread;

import java.util.Timer;
import java.util.TimerTask;

public class GCTaskTest {
	public static void main(String[] args) {
		Timer timer = new Timer();
		GCTask task = new GCTask();
		timer.schedule(task, 5000, 5000);
		int counter = 1;
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}

class GCTask extends TimerTask {
	public void run() {
		System.out.println("Running the scheduled task...");
		System.gc();
	}
}