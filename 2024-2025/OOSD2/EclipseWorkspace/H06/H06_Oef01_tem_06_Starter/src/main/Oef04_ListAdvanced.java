package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class CollectionOperaties {

	/**
	 * Verwijdert uit een collectie van Strings alle Strings die beginnen met een
	 * bepaalde letter.
	 * 
	 * @param collectie de collectie van Strings
	 * @param letter    de beginletter die aangeeft of een String al dan niet
	 *                  verwijderd moet worden uit collectie
	 * 
	 * @return true indien er elementen uit collectie werden verwijderd; false
	 *         indien de collectie ongewijzigd bleef
	 */
	public static boolean verwijderOpBasisVanLetter(Collection<String> collectie, char letter) {
		boolean gewijzigd = false;
		Iterator<String> it = collectie.iterator();
		while (it.hasNext()) {
			String str = it.next();
			if (str.indexOf(letter) == 0) {
				it.remove();
				gewijzigd = true;
			}
		}
		return gewijzigd;
	}

	/**
	 * Verwijdert elementen uit een lijst van Strings. De elementen die verwijderd
	 * worden zijn alle elementen die zich tussen het eerste en het laatste
	 * voorkomen van een bepaalde String bevinden. Merk op dat de opgegeven String
	 * deel uitmaakt van de elementen die moeten verwijderd worden.
	 * 
	 * Indien de opgegeven String niet voorkomt in de lijst zullen er geen elementen
	 * verwijderd worden. Indien de opgegeven String slechts 1 keer voorkomt in de
	 * lijst dan wordt enkel de opgegeven String verwijderd uit de lijst.
	 * 
	 * @param lijst de lijst waaruit elementen moeten verwijderd worden
	 * @param grens de String die bepaalt welke elementen moeten verwijderd worden,
	 * 
	 * @return true indien er elementen uit de lijst werden verwijderd; false indien
	 *         de lijst ongewijzigd bleef
	 */
	public static boolean verwijderElementen(List<String> lijst, String grens) {
//		int firstGrens = lijst.indexOf(grens);
//		int lastGrens = lijst.lastIndexOf(grens);
//		
//		if (firstGrens == lastGrens) {
//			if (firstGrens == -1) return false;
//			lijst.remove(firstGrens);
//			return true;
//			}
//
//		ListIterator<String> it = lijst.listIterator(firstGrens);
//		int index = firstGrens;
//		while (it.hasNext() && index <= lastGrens) {
//			it.next();
//			it.remove();
//			index++;
//		}
//		
//		return true;

//		KORTER
		boolean gewijzigd = false;
		int first = lijst.indexOf(grens);
		if (first != -1) {
			int last = lijst.lastIndexOf(grens);
			lijst.subList(first, last + 1).clear(); // toIndex is exclusive dus  + 1
			gewijzigd = true;
		}
		return gewijzigd;
	}

	/**
	 * Voegt een gegeven String toe aan een geordende lijst van Strings. Na
	 * toevoeging is de lijst nog steeds geordend. Indien de toe te voegen String
	 * reeds aanwezig is in de lijst zal de lijst niet gewijzigd worden.
	 * 
	 * @param lijst        de geordende lijst van Strings
	 * @param nieuwElement het element dat moet toegevoegd worden
	 * 
	 * @return true indien het opegegeven element werd toegevoegd aan de lijst; in
	 *         andere gevallen false.
	 */
	public static boolean voegElementToeOpDeJuistePLaats(List<String> lijst, String nieuwElement) {
//		if (lijst.contains(nieuwElement))
//			return false;
//		lijst.add(nieuwElement);
//		lijst.sort(null);
//		return true;

//		EFFICIËNTER
		boolean gewijzigd = false;
		int index = Collections.binarySearch(lijst, nieuwElement); // binary search is efficiënter op grote datasets
		if (index < 0) {
			lijst.add(index * - 1 - 1, nieuwElement);
			gewijzigd = true;
		}
		return gewijzigd;
	}
}

public class Oef04_ListAdvanced {

	public static void main(String args[]) {
		String kist[][] = { { "appel", "peer", "citroen", "kiwi", "perzik" },
				{ "banaan", "mango", "citroen", "kiwi", "aardbei", "pruim" },
				{ "sinaasappel", "litchi", "kriek", "kers", "papaya" } };

		// Voeg de drie kisten samen in de ArrayList genaamd alleFruit.
		// ----------------------------------------------------------
		List<String> alleFruit = new ArrayList<String>();
		for (String[] array : kist) {
			alleFruit.addAll(Arrays.asList(array));
		}

		System.out.printf("Oorspronkelijke lijst met alle fruit: %s%n%n", alleFruit);

		if (CollectionOperaties.verwijderOpBasisVanLetter(alleFruit, 'p'))
			System.out.printf("Na het verwijderen van het fruit dat start met de letter 'p':  %s%n%n", alleFruit);

		if (CollectionOperaties.verwijderElementen(alleFruit, "kiwi"))
			System.out.printf(
					"Na het verwijderen van alle elementen tussen het eerste en het laatste voorkomen van 'kiwi': %s%n%n",
					alleFruit);

		// Plaats het resultaat terug in de Array mand en sorteer die Array oplopend.
		// Toon het resultaat op het scherm.
		// --------------------------------------------------------------------------
		String[] mand = alleFruit.toArray(new String[alleFruit.size()]);
		Arrays.sort(mand);

		System.out.printf("De gesorteerde array bevat %s%n%n", Arrays.toString(mand));

		Collections.sort(alleFruit);
		if (CollectionOperaties.voegElementToeOpDeJuistePLaats(alleFruit, "sapodilla"))
			System.out.printf("Al het fruit na toevoeging van sapodilla: %s", alleFruit);

	}
}
