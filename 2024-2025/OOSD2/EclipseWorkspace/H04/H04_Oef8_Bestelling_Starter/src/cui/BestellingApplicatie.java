package cui;

import java.util.List;
import java.util.Scanner;

import domein.DomeinController;

public class BestellingApplicatie {
	private static final String[] keuzes = { "Nieuwe bestelling plaatsen", "Overzicht bestellingen tonen", "Stoppen" };
	private Scanner invoer = new Scanner(System.in);
	private final DomeinController dc;

	public BestellingApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		int keuze;
		do {
			keuze = Menu.geefKeuzeUitMenu(keuzes);
			switch (keuze) {
			case 1 -> maakNieuweBestelling();
			case 2 -> toonBestellingen();
			case 3 -> System.out.println("Tot een volgende keer...");
			}
			System.out.println();
		} while (keuze != 3);
	}

	private void toonBestellingen() {
		List<String> overzicht = dc.geefBestellingen();
		if (overzicht.isEmpty()) {
			System.out.println("Er werden geen bestellingen gevonden.");
			return;
		}
		for (String bestelling : dc.geefBestellingen()) {
			System.out.println(bestelling);
		}
	}

	private void maakNieuweBestelling() {
		System.out.print("Geef het aantal printers: ");
		int printers = invoer.nextInt();
		System.out.print("Geef het aantal laptops: ");
		int laptops = invoer.nextInt();
		System.out.print("Geef het aantal scanners: ");
		int scanners = invoer.nextInt();
		dc.voegBestellingToe(printers, laptops, scanners);
		System.out.println("Je bestelling werd geplaatst...\n");
	}
}
