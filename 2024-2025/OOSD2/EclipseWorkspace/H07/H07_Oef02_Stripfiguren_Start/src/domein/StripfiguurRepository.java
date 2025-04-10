package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import persistentie.StripfiguurMapper;

public class StripfiguurRepository {
	private List<Stripfiguur> stripfiguren;
	private final StripfiguurMapper mapper;

	public StripfiguurRepository() {
		this.mapper = new StripfiguurMapper();
		stripfiguren = new ArrayList<>(Arrays.asList(mapper.geefStripfiguren()));
	}

	public Collection<Stripfiguur> geefAlleStripfiguren() {
		return stripfiguren;
	}

	/**
	 * @return alle stripfiguren uit de lijst stripfiguren, gesorteerd op naam
	 */
	public Collection<Stripfiguur> geefStripfigurenGesorteerdOpNaam() {
		return stripfiguren.stream().sorted(Comparator.comparing(Stripfiguur::getNaam)).toList();
	}

	/**
	 * @return alle stripfiguren uit de lijst stripfiguren, aflopend gesorteerd op
	 *         grootte
	 */
	public Collection<Stripfiguur> geefStripfigurenAflopendGesorteerdOpGrootte() {
		return stripfiguren.stream().sorted(Comparator.comparing(Stripfiguur::getGrootte).reversed()).toList();
	}

	/**
	 * Tip: gebruik van Collector om de stream elementen in een Set te verzamelen
	 * 
	 * @return alle stripfiguren uit de lijst stripfiguren zonder dubbels
	 */
	public Collection<Stripfiguur> geefStripfigurenZonderDubbels() {
		return stripfiguren.stream().collect(Collectors.toSet());
	}

	/**
	 * Tip: maak gebruik van de intermediate limit operation
	 * 
	 * @return drie willekeurige stripfuren uit de lijst stripfiguren
	 */
	public Collection<Stripfiguur> geefDrieWillekeurigeStripfiguren() {
		Collections.shuffle(stripfiguren);
		return stripfiguren.stream().limit(3).toList();
	}

	/**
	 * Voegt extra stripfiguren toe aan de lijst met stripfiguren
	 * 
	 * Tip: haal via de mapper de extra stripfiguren op en gebruik de static Stream
	 * methode concat. Zorg dat de lijst wijzigbaar blijft door gebruik te maken van
	 * de toList Collector
	 * 
	 */
	public void voegExtraStripfigurenToe() {
		stripfiguren = Stream.concat(stripfiguren.stream(), Arrays.stream(mapper.geefExtraStripfiguren())).collect(Collectors.toList());
	}

}
