package domein;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class BierWinkel {
	private final Collection<Bier> bieren;

	public BierWinkel(Collection<Bier> bieren) {
		this.bieren = bieren;
	}

	/**
	 * @param percentage het minimum alcohol percentage van de bieren die geteld
	 *                   worden
	 * @return het aantal bieren die een alcoholpercentage groter dan of gelijk aan
	 *         het opegegeven percentage hebben
	 */
	public int geefAantalBierenMetMinAlcoholPercentage(double percentage) {
		return (int) bieren.stream().filter(b -> b.getAlcoholgehalte() >= percentage).count();
	}

	/**
	 * @param percentage het minimum alcohol percentage van de bieren
	 * @return een niet-wijzigbare lijst met bieren die een alcoholpercentage groter
	 *         dan of gelijk aan het opegegeven percentage hebben
	 */
	public Collection<Bier> geefAlleBierenMetMinAlcoholPercentage(double percentage) {
		return bieren.stream().filter(b -> b.getAlcoholgehalte() >= percentage).toList();
	}

	/**
	 * @return een wijzigbare lijst met de namen van alle bieren
	 */
	public Collection<String> geefNamenBieren() {
		return bieren.stream().map(Bier::getNaam).collect(Collectors.toCollection(ArrayList::new));
	}

	/**
	 * @return het bier met het hoogste alcoholpercentage
	 */
	public Bier geefBierMetHoogsteAlcoholPercentage() {
		return bieren.stream().max(Comparator.comparing(Bier::getAlcoholgehalte)).orElse(null);
	}

	/**
	 * @return het bier met het laagste alcoholpercentage
	 */
	public Bier geefBierMetLaagsteAlcoholPercentage() {
		return bieren.stream().min(Comparator.comparing(Bier::getAlcoholgehalte)).orElse(null);
	}

	/**
	 * @return een niet wijzigbare lijst van alle bieren dalend gesorteerd op
	 *         alcoholgehalte; bij gelijke alcoholpercentages worden de bieren
	 *         alfabetisch op naam gesorteerd
	 */
	public Collection<Bier> geefBierenGesorteerdOpAlcoholGehalteEnNaam() {
		return bieren.stream()
				.sorted(Comparator.comparing(Bier::getAlcoholgehalte).reversed().thenComparing(Bier::getNaam)).toList();
	}

	/**
	 * @return een wijzigbare lijst met unieke namen van brouwerijen
	 */
	public Collection<String> geefAlleNamenBrouwerijen() {
		return bieren.stream().map(Bier::getBrouwerij).distinct().collect(Collectors.toList());
	}

	/**
	 * @param woord het woord die moet voorkomen in de naam van de brouwerij
	 * @return een wijzigbare lijst met alle brouwezrijen die het opgegeven woord
	 *         bevatten
	 */
	public Collection<String> geefAlleNamenBrouwerijenMetWoord(String woord) {
		return bieren.stream().map(Bier::getBrouwerij).distinct().filter(b -> b.contains(woord))
				.collect(Collectors.toList());
	}

}
