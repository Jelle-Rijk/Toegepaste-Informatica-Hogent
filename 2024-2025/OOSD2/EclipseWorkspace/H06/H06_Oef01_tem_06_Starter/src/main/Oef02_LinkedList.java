package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Oef02_LinkedList {

	public Oef02_LinkedList() {

		// Cre�er een Integer-array genaamd "arrayGetallen" en
		// initialiseer met 4, 3, 9 en 7
		// -------------------------------------------------------------------
		Integer[] arrayGetallen = new Integer[] { 4, 3, 9, 7 };

		// Cre�er een ArrayList genaamd 'arrayListGetallen' en vul op met de inhoud
		// van arraygetallen (1 instructie)
		// ------------------------------------------------------------------------------
		ArrayList<Integer> arrayListGetallen = new ArrayList<>(Arrays.asList(arrayGetallen));

		// Cre�er een linkedList genaamd "linkedListGetallen" en vul op met de inhoud
		// van arraygetallen (1 instructie)
		// ------------------------------------------------------------------------------
		LinkedList<Integer> linkedListGetallen = new LinkedList<>(Arrays.asList(arrayGetallen));

		// Voeg vooraan in "linkedListGetallen" getal 2 toe
		// ------------------------------------------------
		linkedListGetallen.addFirst(2);

		// Voeg achteraan in "linkedListGetallen" getal 12 toe
		// ---------------------------------------------------
		linkedListGetallen.addLast(12);

		toonOfOplossingJuistIs("2 4 3 9 7 12", linkedListGetallen);

		// Ken aan de variabele eerste het eerste element van "linkedListGetallen" toe
		// ----------------------------------------------------------------------------
		int eerste;
		eerste = linkedListGetallen.removeFirst();

		System.out.printf("%-20s%d%n%-20s%d%n%n", "Modelplossing:", 2, "Jouw oplossing:", eerste);

		// Vervolledig de methodes die je verderop in deze klasse vindt
		// ----------------------------------------------------------------------------

		metEenVerhogen(linkedListGetallen);

		toonOfOplossingJuistIs("5 4 10 8 13", linkedListGetallen);

		elementenMetOnevenIndexVerwijderen(linkedListGetallen);

		toonOfOplossingJuistIs("5 10 13", linkedListGetallen);

		elementenToevoegenNaOnevenGetallen(linkedListGetallen);

		toonOfOplossingJuistIs("5 7 10 13 15", linkedListGetallen);

		// Cre�er een LinkedList genaamd "lijstStrings" en vul op met de inhoud van de
		// array "woorden" (1 instructie)
		// -----------------------------------------------------------------------
		String woorden[] = { "aaa", "bbb", "ccc", "ddd", "eee", "fff" };
		LinkedList<String> lijstStrings = new LinkedList<>(Arrays.asList(woorden));

		// Vervolledig de methode weergevenLijstOmgekeerdeVolgorde
		// -------------------------------------------------------
		toonOfOplossingJuistIs("fff eee ddd ccc bbb aaa", null);
		drukLijstAfInOmgekeerdeVolgorde(lijstStrings);
	}

	/**
	 * Verhoogt elk getal in een lijst van gehele getallen met 1
	 * 
	 * @param geheleGetallen de lijst met de gehele getallen
	 */
	private void metEenVerhogen(List<Integer> geheleGetallen) {
		geheleGetallen.replaceAll((el) -> {
			return el + 1;
		});
	}

	/**
	 * Verwijdert alle elementen met een oneven index uit een lijst van gehele
	 * getallen
	 * 
	 * @param geheleGetallen de lijst met de gehele getallen
	 */
	private void elementenMetOnevenIndexVerwijderen(List<Integer> geheleGetallen) {
		ListIterator<Integer> it = geheleGetallen.listIterator(geheleGetallen.size());
		while (it.hasPrevious()) {
			int index = it.previousIndex();
			it.previous();
			if (index % 2 != 0) {
				it.remove();
			}
		}
	}

	/**
	 * Voegt in een lijst van gehele getallen na elk oneven getal een nieuw getal
	 * toe. De waarde van het nieuwe getal is de waarde van het oneven getal
	 * verhoogd met 2.
	 * 
	 * Voorbeeld: (5, 10, 13) wordt (5, 7, 10, 13, 15)
	 * 
	 * @param geheleGetallen de lijst met de gehele getallen
	 */
	private void elementenToevoegenNaOnevenGetallen(List<Integer> geheleGetallen) {
		ListIterator<Integer> it = geheleGetallen.listIterator();

		while (it.hasNext()) {
			int getal = it.next();
			if (getal % 2 != 0) {
				it.add(getal + 2);
			}
		}
	}

	/**
	 * Drukt een lijst van Strings af in omgekeerde volgorde
	 * 
	 * @param strings de lijst met de strings
	 */
	private void drukLijstAfInOmgekeerdeVolgorde(List<String> strings) {
		ListIterator<String> it = strings.listIterator(strings.size());
		
		while (it.hasPrevious()) {
			System.out.printf("%s ", it.previous());
		}	
	}

	private <T> void toonOfOplossingJuistIs(String oplossing, List<T> list) {
		System.out.printf("%-20s%s%n%-20s", "Modeloplossing:", oplossing, "Jouw oplossing:");
		if (list != null) {
			for (T e : list)
				System.out.printf("%s ", e);
			System.out.printf("%n%n");
		}
	}

	public static void main(String args[]) {
		new Oef02_LinkedList();
	}
}
