package main;

import java.util.ArrayList;
import java.util.List;

public class MultiThreading {

	private static final int AMOUNT_THREADS = 10;
	private static final int MIN_RANGE = 2;
	private static final int MAX_RANGE = 100000;

	public static void main(String[] args) {

		List<FindPrimesThread> threads = new ArrayList<>();

		System.out.println("Creating threads ...");

		for (int i = 0; i < AMOUNT_THREADS; i++) {
			FindPrimesThread thread = new FindPrimesThread(i, MIN_RANGE, MAX_RANGE);
			threads.add(thread);
		}

		System.out.println("Threads created.");
		System.out.println("Starting threads ...");

		for (int i = 0; i < AMOUNT_THREADS; i++) {
			threads.get(i).start();
			System.out.println(String.format("Threads %d has started.", i));
		}

		// Dit wordt meteen getoond: waarom?
		System.out.println("Threads have started.");
		System.out.println("This could take a while: please wait ...");

		for (var t : threads) {
			try {
				t.join(); // Wat doet dit?
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}

		// Dit print pas als alle threads afgewerkt zijn: waarom?
		System.out.println("All threads have finished.");
	}
}