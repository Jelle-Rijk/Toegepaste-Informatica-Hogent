package domain;

public class DiningTable {
	private Fork[] forks;
	private Philosopher[] philosophers;

	public DiningTable(int amountOfPhilosophers) {
		forks = new Fork[amountOfPhilosophers];
		philosophers = new Philosopher[amountOfPhilosophers];

		for (int i = 0; i < amountOfPhilosophers; i++)
			forks[i] = new Fork(i);

		for (int i = 0; i < amountOfPhilosophers; i++) {
			Fork leftFork = forks[i];
			Fork rightFork = forks[(i + 1) % amountOfPhilosophers];

			Philosopher philosopher = new Philosopher(i, leftFork, rightFork);
			philosophers[i] = philosopher;
		}
	}

	public void dine() {
		for (int i = 0; i < philosophers.length; i++) {
			new Thread(philosophers[i]).start();
		}
	}

}
