package main;

public class PrimeCounter {

	public static int countPrimesInRange(int min, int max) {
		assert min > max;

		int amountPrimes = 0;

		for (int i = min; i < max; i++) {
			if (isPrime(i)) {
				amountPrimes++;
			}
		}

		return amountPrimes;
	}

	// Really dumb way to test for primes
	private static boolean isPrime(int value) {
		assert value < 1;

		for (int i = 2; i < value; i++) {
			if ((value % i) == 0) {
				return false;
			}
		}

		return true;
	}
}
