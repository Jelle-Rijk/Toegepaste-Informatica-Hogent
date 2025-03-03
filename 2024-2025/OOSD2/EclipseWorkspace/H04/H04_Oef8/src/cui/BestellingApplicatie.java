package cui;

import java.util.List;
import java.util.Scanner;

import domein.DomeinController;
import exceptions.BestellingException;

public class BestellingApplicatie {
	private String[] keuzes = new String[] { "Nieuwe bestelling plaatsen", "Overzicht bestellingen tonen", "Stoppen" };
	private Scanner invoer = new Scanner(System.in);
	private DomeinController dc;

	public BestellingApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		boolean magStoppen = false;
		do {
			Menu.toonMenu(keuzes);
			try {
				switch (Menu.geefKeuzeUitMenu(keuzes)) {
				case 1 -> maakNieuweBestelling();
				case 2 -> toonBestellingen();
				case 3 -> magStoppen = true;
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.printf("Geef een geheel getal in tussen 1 en %d%n", keuzes.length);
			}
		} while (!magStoppen);
		System.out.println("Tot een volgende keer...");
	}

	private void toonBestellingen() {
		List<String> bestellingen = dc.geefBestellingen();
		if (bestellingen.size() == 0) {
			System.out.println("Er zijn nog geen bestellingen");
			return;
		}
		for (String bestelling : dc.geefBestellingen()) {
			System.out.println(bestelling);
		}
	}

	private void maakNieuweBestelling() {
		boolean geldig = false;
		do {
		int printers = vraagAantal("printers", 4);
		int scanners = vraagAantal("scanners", 3);
		int laptops = vraagAantal("laptops", 2);
		try {
			dc.voegBestellingToe(printers, scanners, laptops);
			System.out.println("Je bestelling werd geplaatst...");
			geldig = true;
		} catch (BestellingException e) {
			System.out.println(e.getMessage());
		}} while(!geldig);
	}

	public int vraagAantal(String vraag, int maximum) {
		int aantal = -1;
		boolean geldig = false;
		do {
			try {
				System.out.print(String.format("Geef aantal %s: ", vraag));
				aantal = Integer.parseInt(invoer.nextLine());
				if (aantal < 0 || aantal > maximum)
					throw new IndexOutOfBoundsException();
				geldig = true;
			} catch (NumberFormatException | IndexOutOfBoundsException e) {
				System.out.printf("Geef een geheel getal tussen 0 en %d%n", maximum);
			}
		} while (!geldig);
		return aantal;
	}
}
