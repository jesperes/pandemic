package pandemic;

import pandemic.console.ConsoleRenderer;

public class Main {
	final static int width = 40;
	final static int height = 20;
	final static int numActors = 20;

	/**
	 * Sleep a given number of milliseconds.
	 * 
	 * @param millis
	 */
	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) {
		World w = new World(width, height, numActors, new ConsoleRenderer());

		int i = 0;
		while (true) {
			System.out.format("Step: %d\n", i++);
			w.step();
			sleep(1000);
		}
	}
}
