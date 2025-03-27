package main;

import java.util.Scanner;

/**
 * Maak in de klasse OefStackQueue gebruik van de Scanner invoer om 10 woorden
 * in te lezen. Plaats de woorden telkens op een stack en op een queue.
 * 
 * Druk dan de woordjes in twee kolommen van 20 tekens breed af. De eerste kolom
 * bevat de woorden uit de stack, de tweede kolom de woorden uit de queue.
 * 
 */

// * Voorbeeld voor invoer van de woorden: een twee drie vier vijf zes zeven acht
// * negen tien
// * 
// * Merk op dat de uitvoer in deze commentaar geen rekening houdt met kolombreedte.
// *
// * Stack Queue
// * tien een 
// * negen twee 
// * acht drie 
// * zeven vier 
// * zes vijf 
// * vijf zes 
// * vier zeven 
// * drie
// * acht 
// * twee negen 
// * een tien

public class Oef06_ArrayDeque {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String woord;

		// declareer en initializeer stack en queue
		// ----------------------------------------

		System.out.println("Start invoer: ");
		for (int aantal = 1; aantal <= 10; aantal++) {
			// lees woord en plaats het in de stack en de queue
		}

		// druk hoofding
		System.out.printf("%20s%20s%n%n", "Stack", "Queue");

		// zolang containers niet ledig, druk een regel met betreffende woord
		// ------------------------------------------------------------------
	}
}
