package main;

public class FindPrimesThread extends Thread {
	private final int id;
	private final int min;
	private final int max;

	public FindPrimesThread(int id, int min, int max) {
		this.id = id;
		this.min = min;
		this.max = max;
	}

	@Override
	public void run() {
		int primes = PrimeCounter.countPrimesInRange(min, max);
		System.out.printf("Thread %d found %d primes in the range [%d, %d[%n", id, primes, min, max);

	}
}