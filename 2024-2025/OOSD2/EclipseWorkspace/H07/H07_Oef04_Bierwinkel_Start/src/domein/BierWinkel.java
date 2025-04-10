package domein;

import java.util.Collection;

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
		return 0;
	}

	/**
	 * @param percentage het minimum alcohol percentage van de bieren
	 * @return een niet-wijzigbare lijst met bieren die een alcoholpercentage groter
	 *         dan of gelijk aan het opegegeven percentage hebben
	 */
	public Collection<Bier> geefAlleBierenMetMinAlcoholPercentage(double percentage) {
		return null;
	}

	/**
	 * @return een wijzigbare lijst met de namen van alle bieren
	 */
	public Collection<String> geefNamenBieren() {
		return null;
	}

	/**
	 * @return het bier met het hoogste alcoholpercentage
	 */
	public Bier geefBierMetHoogsteAlcoholPercentage() {
		return null;
	}

	/**
	 * @return het bier met het laagste alcoholpercentage
	 */
	public Bier geefBierMetLaagsteAlcoholPercentage() {
		return null;
	}

	/**
	 * @return een niet wijzigbare lijst van alle bieren dalend gesorteerd op
	 *         alcoholgehalte; bij gelijke alcoholpercentages worden de bieren
	 *         alfabetisch op naam gesorteerd
	 */
	public Collection<Bier> geefBierenGesorteerdOpAlcoholGehalteEnNaam() {
		return null;
	}

	/**
	 * @return een wijzigbare lijst met unieke namen van brouwerijen
	 */
	public Collection<String> geefAlleNamenBrouwerijen() {
		return null;
	}

	/**
	 * @param woord het woord die moet voorkomen in de naam van de brouwerij
	 * @return een wijzigbare lijst met alle brouwezrijen die het opgegeven woord
	 *         bevatten
	 */
	public Collection<String> geefAlleNamenBrouwerijenMetWoord(String woord) {
		return null;
	}

}
