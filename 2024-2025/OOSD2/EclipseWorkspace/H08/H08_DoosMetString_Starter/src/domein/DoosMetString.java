package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoosMetString {
	private String inhoud;

	public DoosMetString(String inhoud) {
		super();
		setInhoud(inhoud);
	}

	public String getInhoud() {
		return inhoud;
	}

	private void setInhoud(String inhoud) {
		if (inhoud == null || inhoud.isEmpty())
			throw new IllegalArgumentException("Je moet de inhoud opgeven");
		this.inhoud = inhoud;
	}

	/**
	 * @return het middelste karakter van het attribuut inhoud
	 */
	public char geefMiddelsteKarakterVanInhoud() {
		return inhoud.charAt(inhoud.length() / 2);
	}

	/**
	 * @return een string die het attribuut inhoud omgekeerd bevat
	 */
	public String geefOmgekeerdeInhoud() {
		return new StringBuilder(inhoud).reverse().toString();
	}

	/**
	 * @return true indien attribuut inhoud een palindroom bevat, false in andere
	 *         gevallen
	 */
	public boolean bevatPalindroom() {
		String reverse = new StringBuilder(inhoud).reverse().toString();
		return reverse.equals(inhoud);
	}

	/**
	 * @param letter1 de letter die we wensen te vervangen
	 * @param letter2 de vervang letter
	 * 
	 * @return een string die het attribuut inhoud bevat waarbij elke voorkomen van
	 *         letter1 werd vervangen door letter2, dit gebeurt case-insensitive:
	 *         hoofdletters letter1 worden vervangen door hoofdletters letter2 en
	 *         idem voor kleine letters
	 */
	public String geefWartaal(char letter1, char letter2) {
		return inhoud.replace(Character.toLowerCase(letter1), Character.toLowerCase(letter2))
				.replace(Character.toUpperCase(letter1), Character.toUpperCase(letter2));
	}

	/**
	 * @param woord de string waarond we willen opsplitsen
	 * 
	 * @return een array van strings die het resultaat zijn van het attribuut inhoud
	 *         op te splitsen rond elk voorkomen van woord
	 */
	public String[] splitsOp(String woord) {
		return inhoud.split(woord);

		/*
		 * StringBuilder builder = new
		 * StringBuilder("\\s*").append(woord).append("\\s*");
		 * 
		 * return inhoud.split(builder.toString());
		 */
	}

	/**
	 * @return een string die bevat hoeveel klinkers, medeklinkers, cijfers, kleine
	 *         letters, hoofdletters en andere karakters bevat
	 */
	public String geefLetterRapport() {
		StringBuilder rapport = new StringBuilder();
		String[] categorieën = new String[] { "Klinker", "Medeklinker", "Cijfer", "Andere", "Kleine letter",
				"Hoofdletter" };
		int[] tellers = new int[categorieën.length];
		List<Character> klinkers = new ArrayList<Character>(Arrays.asList(new Character[] { 'a', 'e', 'i', 'o', 'u' }));

		for (char c : inhoud.toCharArray()) {
			if (Character.isDigit(c))
				tellers[2]++;
			else if (Character.isLetter(c)) {
				tellers[klinkers.contains(c) ? 0 : 1]++;
				tellers[Character.isLowerCase(c) ? 4 : 5]++;
			} else
				tellers[3]++;
		}

		rapport.append(String.format("Gevonden in de zin \"%s\"%n%n%20s%20s%n", inhoud, "Soort karakter", "Aantal"));
		for (int i = 0; i < categorieën.length; i++)
			rapport.append(String.format("%20s%20s%n", categorieën[i], tellers[i]));
		return rapport.toString();
	}
}
