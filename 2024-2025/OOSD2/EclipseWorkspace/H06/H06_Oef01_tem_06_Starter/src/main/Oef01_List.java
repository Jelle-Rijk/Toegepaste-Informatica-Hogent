package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Oef01_List {

	private static final String[] COLORS = { "red", "white", "blue" };

	// Declareer lijstMetKleuren en eenAndereLijst van type List.
	// De elementen van deze twee collections zijn van het type String.
	// ----------------------------------------------------------------
	List<String> lijstMetKleuren;
	List<String> eenAndereLijst;

	public static void main(String args[]) {
		new Oef01_List();
	}

	public Oef01_List() {

		// Ken, in 1 instructie, een nieuwe ArrayList toe aan lijstMetKleuren en
		// zorg dat deze meteen alle waarden van de constante COLORS bevat
		// ---------------------------------------------------------------------
		lijstMetKleuren = new ArrayList<>(Arrays.asList(COLORS));

		// Voeg aan het einde van lijstMetKleuren "green" toe
		// --------------------------------------------------
		lijstMetKleuren.add("green");

		// Voeg "green" toe op de derde plaats in lijstMetKleuren
		// ------------------------------------------------------
		lijstMetKleuren.add(2, "green");

		toonOfOplossingJuistIs("red white green blue green", lijstMetKleuren);

		// Verwijder het tweede element uit lijstMetKleuren
		// ------------------------------------------------
		lijstMetKleuren.remove(1);

		toonOfOplossingJuistIs("red green blue green", lijstMetKleuren);

		// Verwijder uit lijstMetKleuren het eerste voorkomen van de string "green"
		// -------------------------------------------------------------------
		lijstMetKleuren.remove("green");

		toonOfOplossingJuistIs("red blue green", lijstMetKleuren);

		// Geef het tweede element weer op het scherm d.m.v. printf
		// --> Als je dit goed doet verschijnt "Het tweede element is blue" op het
		// scherm
		// --------------------------------------------------------
		System.out.printf("Het tweede element is %s%n", lijstMetKleuren.get(1));
		System.out.println();

		// Vervolledig de for-lus.
		// Druk, d.m.v. 1 printf statement, op het scherm af of de waarde van de
		// lus-variabele eenKleur al dan niet voorkomt in lijstMetKleuren
		// --> Als je dit goed doet verschijnt "blue komt voor in de lijst" en
		// "pink komt niet voor in de lijst" op het scherm
		// ----------------------------------------------------------------------
		for (String eenKleur : new String[] { "blue", "pink" }) {
			System.out.printf("%s komt%s voor in de lijst%n", eenKleur, lijstMetKleuren.contains(eenKleur)? "": " niet");
		}
		System.out.println();

		// Wijzig het derde element in lijstMetKleuren naar de string "yellow"
		// -------------------------------------------------------------------
		lijstMetKleuren.set(2, "yellow");

		toonOfOplossingJuistIs("red blue yellow", lijstMetKleuren);

		// Initialiseer eenAndereLijst als een lege ArrayList
		// -----------------------------------------
		eenAndereLijst = new ArrayList<>();

		// Kopieer, gebruik makend van 1 instructie, de inhoud vaan lijstMetKleuren naar
		// eenAndereLijst
		// -------------------------------------------------------------------------------------
		eenAndereLijst.addAll(lijstMetKleuren);

		// Druk op het scherm af of lijstMetKleuren en eenAnderLijst
		// verwijzen naar eenzelfde lijst
		// --> Als je dit goed doet verschijnt "lijstMetKleuren en eenAndereLijst
		// verwijzen niet naar dezelfde lijst" op het scherm
		// -----------------------------------------------------------------------
		System.out.printf("lijstMetKleuren en eenAndereLijst verwijzen%s naar dezelfde lijst%n", lijstMetKleuren == eenAndereLijst ? "" : " niet");
		System.out.println();
		// Druk op het scherm af of lijstMetKleuren en eenAnderLijst equal zijn (gebruik
		// equals)
		// --> Als je dit goed doet verschijnt "lijstMetKleuren en eenAndereLijst zijn
		// equal" op het scherm
		// ----------------------------------------------------------------------------
		System.out.printf("lijstMetkleuren en eenAndereLijst zijn%s equal%n", lijstMetKleuren.equals(eenAndereLijst)? "" : "niet");

		// Vervolledig de methodes (zie verderop deze klasse) die hier worden
		// aangeroepen. Beide void-methodes muteren de doorgegeven lijst
		// -------------------------------------------------------------------
		naarHoofdletterOmzetten(lijstMetKleuren);
		toonOfOplossingJuistIs("RED BLUE YELLOW", lijstMetKleuren);

		naarKleineLettersOmzetten(lijstMetKleuren);
		toonOfOplossingJuistIs("red blue yellow", lijstMetKleuren);
	}

	/**
	 * Zet alle Strings in een lijst van Strings volledig in hoofdletters
	 * 
	 * @param lijstMetKleuren de lijst met Strings
	 */
	private void naarHoofdletterOmzetten(List<String> lijstMetKleuren) {
		for (String s : lijstMetKleuren)
			s.toUpperCase();
	}

	/**
	 * Zet alle Strings in een lijst van Strings volledig in kleine letters. Maak
	 * hier gebruik van een method reference.
	 * 
	 * @param lijstMetKleuren de lijst met Strings
	 */
	private void naarKleineLettersOmzetten(List<String> lijstMetKleuren) {
		lijstMetKleuren.forEach(String::toLowerCase);
	}

	private void toonOfOplossingJuistIs(String oplossing, List<String> list) {
		System.out.printf("%-20s%s%n%-20s", "Modeloplossing:", oplossing, "Jouw oplossing:");
		if (list != null)
			for (String e : list)
				System.out.printf("%s ", e);
		System.out.println("\n");
	}

}
