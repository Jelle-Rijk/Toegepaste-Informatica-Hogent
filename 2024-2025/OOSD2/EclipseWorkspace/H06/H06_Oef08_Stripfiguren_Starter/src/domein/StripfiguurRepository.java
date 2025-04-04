package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import persistentie.StripfiguurMapper;

public class StripfiguurRepository {
	private final List<Stripfiguur> stripfiguren;
	private final StripfiguurMapper mapper;

	public StripfiguurRepository() {
		this.mapper = new StripfiguurMapper();
		stripfiguren = new ArrayList<>(Arrays.asList(mapper.geefStripfiguren()));
	}

	/**
	 * @return alle stripfiguren uit de lijst stripfiguren
	 */
	public Collection<Stripfiguur> geefAlleStripfiguren() {

	}

	/**
	 * @return alle stripfiguren uit de lijst stripfiguren, gesorteerd op naam
	 */
	public Collection<Stripfiguur> geefStripfigurenGesorteerdOpNaam() {

	}

	/**
	 * @return alle stripfiguren uit de lijst stripfiguren, aflopend gesorteerd op
	 *         grootte
	 */
	public Collection<Stripfiguur> geefStripfigurenAflopendGesorteerdOpGrootte() {

	}

	/**
	 * Tip: maak gebruik van een Set datastructuur
	 * 
	 * @return alle stripfiguren uit de lijst stripfiguren zonder dubbels
	 */
	public Collection<Stripfiguur> geefStripfigurenZonderDubbels() {

	}

	/**
	 * Tip: maak gebruik van de shuffle methode
	 * 
	 * @return drie willekeurige stripfuren uit de lijst stripfiguren
	 */
	public Collection<Stripfiguur> geefDrieWillekeurigeStripfiguren() {

	}

	/**
	 * Voeg een nieuwe stripfiguur toe aan de lijst stripfiguren
	 * 
	 * @param naam    de naam van de nieuwe stripfiguur
	 * @param grootte de grootte van de nieuwe stripfiguur
	 */
	public void voegStripfiguurToe(String naam, double grootte) {

	}

	/**
	 * Voegt extra stripfiguren toe aan de lijst met stripfiguren
	 * 
	 * Tip: haal via de mapper de extra stripfiguren op en voeg ze in bulk toe aan
	 * de lijst stripfiguren
	 */
	public void voegExtraStripfigurenToe() {

	}
}
