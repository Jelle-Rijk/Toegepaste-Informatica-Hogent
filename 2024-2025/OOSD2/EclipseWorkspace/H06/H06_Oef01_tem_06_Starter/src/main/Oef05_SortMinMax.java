package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Zorg dat de klasse BoekComparator de interface Comparator implementeert.
 * 
 * De compare methode vergelijkt boeken alfabetisch op titel. Bij gelijke titels
 * wordt vergeleken op basis van isbn_nr (let op: hogere isbn-nr's komen voor
 * lagere isbn-nr's)
 *
 * Tip: vergeet ook niet de equals en hashCode consistent te overschrijven, i.e.
 * equals retourneert true wanneer de titel en het isbn-nr van twee boeken
 * gelijk zijn.
 *
 */
class Boek implements Comparable<Boek> {

	private String titel;
	private long isbn_nr;

	public Boek(String titel, long isbn_nr) {
		this.titel = titel;
		this.isbn_nr = isbn_nr;
	}

	public String getTitel() {
		return titel;
	}

	public long getIsbn_nr() {
		return isbn_nr;
	}

	@Override
	public String toString() {
		return String.format("%s %d", titel, isbn_nr);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (o.getClass() != getClass())
			return false;
		Boek b = (Boek) o;
		return b.getTitel().equals(titel) && b.getIsbn_nr() == isbn_nr;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(titel, isbn_nr);
	}

	@Override
	public int compareTo(Boek o) {
		int titelCompare = titel.compareTo(o.getTitel());
		return titelCompare == 0 ? Long.compare(isbn_nr,  o.getIsbn_nr()) : titelCompare;
	}
}

public class Oef05_SortMinMax {

	public Oef05_SortMinMax() {
		List<Boek> boeken = new ArrayList<>();
		boeken.add(new Boek("How To Program", 1130927384L));
		boeken.add(new Boek("How To Program", 9830927384L));
		boeken.add(new Boek("JAVA", 1140927384L));
		boeken.add(new Boek("C++", 2200000000L));
		boeken.add(new Boek("C++", 8800000000L));

		// Sorteer de boeken volgens hun natuurlijke ordening
		// --------------------------------------------------
		boeken.sort(null);
		System.out.println("De gesorteerde boeken (natuurlijke ordening): ");
		toonLijst(boeken);

		// Zet de arrayList om in omgekeerde volgorde (= 1 instructie)
		// -----------------------------------------------------------
		Collections.reverse(boeken);
		System.out.println("De boeken in omgekeerde volgorde: ");
		toonLijst(boeken);

		// Sorteer de boeken op basis van BoekComparator
		// ----------------------------------------------
		boeken.sort(new BoekComparator());
		System.out.println("De gesorteerde boeken (totale ordening): ");
		toonLijst(boeken);

		Integer getallen[] = { 6, 5, 9, 3 };
		// Ken aan max het grootste element van de array getallen toe
		// ----------------------------------------------------------
		int max = Collections.max(Arrays.asList(getallen));
		System.out.printf("Het maximum in %s is %d.%n", Arrays.toString(getallen), max);

		// Ken aan min het kleinste element van de array getallen toe
		// ----------------------------------------------------------
		int min = Collections.min(Arrays.asList(getallen));
		System.out.printf("Het minimum in %s is %d.%n", Arrays.toString(getallen), min);
	}

	public void toonLijst(Collection<Boek> collection) {
		for (Boek element : collection) {
			System.out.printf("%s%n", element);
		}
		System.out.println("\n");
	}

	public static void main(String args[]) {
		new Oef05_SortMinMax();
	}

	/**
	 * Zorg dat de klasse BoekComparator de interface Comparator implementeert.
	 * 
	 * De compare methode zorgt dat boeken stijgend op ISBN-nummer geordend worden.
	 *
	 */
	private class BoekComparator implements Comparator<Boek> {

		@Override
		public int compare(Boek b1, Boek b2) {
			return Long.compare(b2.getIsbn_nr(), b1.getIsbn_nr());
		}

	}

}
