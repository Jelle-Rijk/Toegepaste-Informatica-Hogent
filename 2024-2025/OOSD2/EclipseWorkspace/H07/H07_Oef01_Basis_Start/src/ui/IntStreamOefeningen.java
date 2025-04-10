package ui;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamOefeningen {

	public static void start() {
		int[] resultaten = { 10, 15, 8, 18, 19, 0, 6 };

		System.out.printf("Verwacht aantal geslaagden: %d%n", 4);
		System.out.printf("Jouw aantal geslaagden: %d%n%n", geefAantalGeslaagden(resultaten));
		System.out.printf("Verwacht gemiddelde: %.2f%n", 15.50);
		System.out.printf("Jouw gemiddelde: %.2f%n%n", geefGemiddeldeVanGeslaagden(resultaten));
		System.out.printf("Verwachte gesorteerde en opgemaakte resultaten: %s%n", "0 - 6 - 8 - 10 - 15 - 18 - 19");
		System.out.printf("Jouw gesorteerde en opgemaakte resultaten: %s%n%n", geefGesorteerdeResultaten(resultaten));
		System.out.printf("Verwacht antwoord op bevat maximum score: %s%n", false);
		System.out.printf("Jouw antwoord op bevat maximum score: %s%n%n", bevatMaximumScore(resultaten));
		resultaten[5] = 20;
		System.out.printf("Verwacht antwoord op bevat maximum score na wijziging: %s%n", true);
		System.out.printf("Jouw antwoord op bevat maximum score na wijziging: %s%n%n", bevatMaximumScore(resultaten));
		int[] resultatenGeslaagden = geefResultatenVanGeslaagden(resultaten);
		System.out.printf("Verwachte inhoud van array met resultaten van geslaagden:%s%n", "\n10\n15\n18\n19\n20");
		System.out.printf("Jouw inhoud van array met resultaten van geslaagden:%n");
		IntStream.of(resultatenGeslaagden).forEach(r -> System.out.println(r));
	}

	/**
	 * @param resultaten een array met getallen tussen O en 20
	 * @return het aantal getallen die groter of gelijk aan 10 zijn
	 */
	private static int geefAantalGeslaagden(int[] resultaten) {
		return (int) Arrays.stream(resultaten).filter(e -> e >= 10).count();
	}

	/**
	 * @param resultaten een array met getallen tussen O en 20
	 * @return het gemiddelde van alle getallen die groter of gelijk aan 10 zijn
	 */
	private static double geefGemiddeldeVanGeslaagden(int[] resultaten) {
		return Arrays.stream(resultaten).filter(e -> e >= 10).average().getAsDouble();
	}

	/**
	 * @param resultaten een array met getallen tussen O en 20
	 * @return een String die de gesorteerde resultaten, met telkens een min-teken,
	 *         ertussen bevat
	 */
	private static String geefGesorteerdeResultaten(int[] resultaten) {
		return Arrays.stream(resultaten).sorted().mapToObj(Integer::toString).collect(Collectors.joining(" - "));
	}

	/**
	 * @param resultaten een array met getallen tussen O en 20
	 * @return een boolean die aangeeft of resultaten al dan niet een getal gelijk
	 *         aan 20 bevat
	 */
	private static boolean bevatMaximumScore(int[] resultaten) {
		return Arrays.stream(resultaten).anyMatch(e -> e == 20);
	}

	/**
	 * @param resultaten een array met getallen tussen O en 20
	 * @return een array met de getallen die groter of gelijk aan 10 zijn
	 */
	private static int[] geefResultatenVanGeslaagden(int[] resultaten) {
		return Arrays.stream(resultaten).filter(e -> e >= 10).toArray();
	}

}
