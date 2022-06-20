package fgp.engine.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr. Hapke
 */
public abstract class TimerThreadWithKill extends Thread {

	private long millis;
	private static List<TimerThreadWithKill> threads = new ArrayList<>();
	static {
		Runtime.getRuntime().addShutdownHook(new Thread("shutdown thread") {
			@Override
			public void run() {
				shutdownThreads();
			}
		});
	}

	public static void shutdownThreads() {
		for (TimerThreadWithKill t : threads) {
			t.kill = true;
		}
	}

	public TimerThreadWithKill(String name, long millis) {
		super(name);
		threads.add(this);
		this.millis = millis;
	}

	protected volatile boolean kill = false;

	public boolean isKill() {
		return kill;
	}

	@Override
	public final void run() {
		while (!kill) {
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				System.out.println(Thread.interrupted());
			}
			if (kill)
				break;
			try {
				doWork();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected abstract void doWork();
}
