package ui;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamOfDateOefeningen {

	public static void start() {
		List<LocalDate> datums = Arrays.asList(LocalDate.of(2022, 11, 28), LocalDate.of(2020, 1, 1),
				LocalDate.of(2023, 8, 16), LocalDate.of(2022, 5, 14), LocalDate.of(2022, 3, 29),
				LocalDate.of(2022, 11, 10), LocalDate.of(2023, 11, 10));

		System.out.printf("Verwacht aantal datums in 2022: %d%n", 4);
		System.out.printf("Jouw aantal datums in 2022: %d%n%n", geefAantalDatumsIn2022(datums));
		System.out.printf("Verwachte eerste datum die in een schrikkeljaar valt: %s%n", "2020-01-01");
		System.out.printf("Jouw eerste datum die in een schrikkeljaar valt: %s%n%n", geefEersteSchrikkeljaar(datums));
		System.out.printf("Verwachte datums in interval: %n%s%n", "2022-03-29\n2022-05-14\n2022-11-10\n2022-11-28");
		System.out.printf("Jouw datums in interval: %n");
		LocalDate[] datumsInInterval = geefGesorteerdeDatumsInInterval(datums, LocalDate.of(2022, 03, 29),
				LocalDate.of(2022, 12, 31));
		for (LocalDate d : datumsInInterval) {
			System.out.println(d);
		}
		System.out.printf("%nVerwachte unieke jaartallen: %s%n", "2022, 2020, 2023");
		System.out.printf("Jouw unieke jaartallen: %s%n", geefUniekeJaartallen(datums));
		System.out.printf("%nVerwachte unieke gesorteerde weekdagen: %n%s%n",
				"MONDAY\nTUESDAY\nWEDNESDAY\nTHURSDAY\nFRIDAY\nSATURDAY");
		System.out.printf("Jouw unieke gesorteerde weekdagen: %n");
		Collection<DayOfWeek> weekdagen = geefUniekeWeekdagen(datums);
		weekdagen.stream().forEach(dow -> System.out.println(dow));
		System.out.printf("%nVerwachte oudste datum: %s%n", "2020-01-01");
		System.out.printf("Jouw oudste datum:: %s%n%n", geefOudsteDatum(datums));
		System.out.printf("Verwachte jaartallen: %n%s%n", "2022\n2020\n2023\n2022\n2022\n2022\n2023");
		System.out.printf("Jouw jaartallen: %n");
		int[] jaartallen = geefGesorteerdeJaartallen(datums);
		IntStream.of(jaartallen).forEach(j -> System.out.println(j));
	}

	/**
	 * Tip: er bestaat een LocalDate methode getYear()
	 * 
	 * @param datums een collection met LocalDate objecten
	 * @return het aantal datums die in het jaar 2022 liggen
	 */
	private static int geefAantalDatumsIn2022(Collection<LocalDate> datums) {
		return (int) datums.stream().filter(d -> d.getYear() == 2022).count();
	}

	/**
	 * Tip: er bestaat een LocalDate methode isLeapYear() en een terminal stream
	 * operation findFirst()
	 * 
	 * @param datums een collection met LocalDate objecten
	 * @return de eerste datum die in een schrikkeljaar valt, indien er geen datum
	 *         in een schrikkeljaar valt null
	 */
	private static LocalDate geefEersteSchrikkeljaar(Collection<LocalDate> datums) {
		return datums.stream().filter(e -> e.isLeapYear()).findFirst().get();
	}

	/**
	 * Tip: er bestaan LocalDate methodes isAfter(...) en isBefore(...) en
	 * LocalDates worden op natuurlijke wijze stijgend gesorteerd
	 * 
	 * @param datums een collection met LocalDate objecten
	 * @param van    de ondergrens van het tijdsinterval
	 * @param tot    de bovengrens van het tijdsinterval
	 * @return een array met alle datums, stijgend gesorteerd, die in het interval
	 *         [van, tot] liggen
	 */
	private static LocalDate[] geefGesorteerdeDatumsInInterval(Collection<LocalDate> datums, LocalDate van,
			LocalDate tot) {
		return (LocalDate[]) datums.stream().filter(e -> e.isAfter(van) && e.isBefore(tot) || e.isEqual(van) || e.isEqual(tot)).sorted().toArray(LocalDate[]::new);
	}

	/**
	 * @param datums een collection met LocalDate objecten
	 * @return een String die de unieke jaartallen, gescheiden door een -komma en
	 *         spatie- bevat
	 */
	private static String geefUniekeJaartallen(Collection<LocalDate> datums) {
		return datums.stream().map(e -> Integer.toString(e.getYear())).distinct().collect(Collectors.joining(", "));
	}

	/**
	 * Tip: de LocalDate methode getDayOfWeek() returneert een DayOfWeek
	 * 
	 * @param datums een collection met LocalDate objecten
	 * @return een array die de unieke weekdagen bevat
	 */
	private static Collection<DayOfWeek> geefUniekeWeekdagen(Collection<LocalDate> datums) {
		return datums.stream().map(LocalDate::getDayOfWeek).distinct().sorted().toList();
	}

	/**
	 * @param datums een collection met LocalDate objecten
	 * @return de oudste datum
	 */
	private static LocalDate geefOudsteDatum(Collection<LocalDate> datums) {
		return datums.stream().min(Comparator.naturalOrder()).get();
	}

	/**
	 * @param datums een collection met LocalDate objecten
	 * @return een array met de unieke gesorteerde jaartallen
	 */
	private static int[] geefGesorteerdeJaartallen(Collection<LocalDate> datums) {
		return datums.stream().mapToInt(LocalDate::getYear).distinct().sorted().toArray();
	}

}
