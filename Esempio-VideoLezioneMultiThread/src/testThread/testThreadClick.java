package testThread;

public class testThreadClick implements Runnable {
	private int click = 0;
	private Thread t;
	private boolean running = true;

	public testThreadClick(int p) {
		t = new Thread(this);
		t.setPriority(p);
	}

	public int getClick() {
		return click;
	}

	public void run() {
		while (running) {
			click++;
		}
	}

	public void stopThread() {
		running = false;
	}

	public void startThread() {
		t.start();
	}

	public static void main(String args[]) {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

		testThreadClick hi = new testThreadClick(Thread.NORM_PRIORITY + 2);
		testThreadClick lo = new testThreadClick(Thread.NORM_PRIORITY - 2);
		lo.startThread();
		hi.startThread();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		lo.stopThread();
		hi.stopThread();
		System.out.println(lo.getClick() + " vs. " + hi.getClick());
	}

}
