package domain;

public record Philosopher(int order, Fork leftFork, Fork rightFork) implements Runnable {
	@Override
	public void run() {
		System.out.printf("Philosopher %d wants to pick up left fork (fork %d).\n", order, leftFork.order());
		synchronized (leftFork) {
			System.out.printf(
					"Philosopher %d picks up left fork (fork %d). He waits 1 second before picking up right fork (fork %d)\n",
					order, leftFork.order(), rightFork.order());
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/

			System.out.printf("Philosopher %d wants to pick up right fork (fork %d).\n", order, rightFork.order());
			synchronized (rightFork) {
				System.out.printf("Philosopher %d succesfully picks up right fork (fork %d).\n", order,
						rightFork.order());
			}
		}
	}
}
