package domein;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Garage {
	private List<Onderhoud> onderhouden;

	/**
	 * Vult de lijst met onderhouden
	 * 
	 * @param onderhouden de onderhouden die in de lijst moeten komen
	 */
	public Garage(Collection<Onderhoud> onderhouden) {
		this.onderhouden = new ArrayList<>(onderhouden);
	}

	/**
	 * Retourneert een Collection met alle unieke auto's uit de onderhouden,
	 * gesorteerd op nummerplaat (i.e. natuurlijke ordening)
	 * 
	 * tip: voeg alle auto's uit de onderhouden toe aan een Set om de unieke auto's
	 * te hebben
	 */
	public Collection<Auto> geefAlleAutosInOnderhoud() {
		Set<Auto> autos = new HashSet<>();
		for (Onderhoud onderhoud : onderhouden)
			autos.add(onderhoud.getAuto());
		return autos;
	}

	public Collection<Onderhoud> getOnderhouden() {
		return onderhouden;
	}

	/**
	 * Sorteert de onderhouden op basis van de natuurlijke ordening voor Auto, en
	 * vervolgens, voor gelijke auto's, op begindatum van het onderhoud.
	 * 
	 */
	public void sorteerOnderhouden() {
		onderhouden.sort(Comparator.comparing(Onderhoud::getAuto).thenComparing(Onderhoud::getBegindatum));
	}

	/**
	 * Voegt alle aaneengrenzende onderhouden samen.
	 * 
	 * Tip: Roep de hulpmethode sorteerOnderhoudLijst aan om de onderhoudLijst eerst
	 * te sorteren, en voeg dan alle aaneengrenzende onderhouden samen tot 1
	 * onderhoud.
	 * 
	 * Merk op: indien je dit nog niet deed, implementeer je eerst de methode
	 * isAangrenzendMet in de klasse Onderhoud
	 * 
	 */

	public void voegAaneengrenzendeOnderhoudenSamen() {
		sorteerOnderhouden();
		Iterator<Onderhoud> it = onderhouden.iterator();
		Onderhoud currentOnderhoud = null;
		Onderhoud nextOnderhoud = null;
		while (it.hasNext()) {
			currentOnderhoud = nextOnderhoud;
			nextOnderhoud = it.next();
			if (currentOnderhoud != null && currentOnderhoud.isAangrenzendMet(nextOnderhoud)) {
				currentOnderhoud.setEinddatum(nextOnderhoud.getEinddatum());
				it.remove();
				nextOnderhoud = currentOnderhoud;
			}			
		}
	}

}
