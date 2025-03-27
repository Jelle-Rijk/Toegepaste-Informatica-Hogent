package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Oef03_BulkOps {

	public static void main(String args[]) {
		String[] fruit1 = { "appel", "peer", "citroen", "kiwi" };
		String[] fruit2 = { "banaan", "mango", "citroen", "kiwi", "aardbei" };

		// Behandel fruit1 en fruit2 als Collections en maak gebruik van de bulk
		// operaties om volgende output te leveren:
		//
		// Fruit die voorkomt in fruit2 maar niet in fruit1: [banaan, mango, aardbei]
		// Fruit die voorkomt in fruit1 maar niet in fruit2: [appel, peer]
		// Fruit die voorkomt in fruit1 en fruit2: [citroen, kiwi]
		//
		// Maak gebruik van een variabele genaamd resultaat om de tussenstappen bij te
		// houden

		
		Collection<String> resultaat = new ArrayList<String>(Arrays.asList(fruit2));
		resultaat.removeAll(Arrays.asList(fruit1));
		System.out.printf("Fruit die voorkomt in fruit2 maar niet in fruit 1 %s%n", resultaat);

		resultaat = new ArrayList<String>(Arrays.asList(fruit1));
		resultaat.removeAll(Arrays.asList(fruit2));
		System.out.printf("Fruit die voorkomt in fruit1 maar niet in fruit2: %s%n", resultaat);

		resultaat = new ArrayList<String>(Arrays.asList(fruit1));
		resultaat.retainAll(Arrays.asList(fruit2));
		System.out.printf("Fruit die voorkomt in fruit1 en fruit2: %s%n", resultaat);
	}
}
