package ui;

import java.util.Scanner;

import domein.DomeinController;

public class VertoonbaarApplicatie {

	private final DomeinController dc;
	private final Scanner invoer = new Scanner(System.in);

	public VertoonbaarApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		int keuze = maakKeuzeUitMenu(0);
		while (keuze != 4) {

			switch (keuze) {
			case 1 -> drukOverzichtVoorstellingenAf();
			case 2 -> voegVoorstellingToe();
			case 3 -> System.out.printf("Het aantal voorstellingen bedraagt %d%n", geefAantalInZaal());
			}

			keuze = maakKeuzeUitMenu(0);
		}
	}

	private int maakKeuzeUitMenu(int nrMenu) {

		int keuze;
		String[] menu = geefKeuzeMenu(nrMenu);
		int aantalKeuzes = menu.length;
		do {	
			int nr = 1;
			for (String optie : menu)
				System.out.printf("%d. %s%n", nr++, optie);
			System.out.print("Geef je keuze: ");
			keuze = invoer.nextInt();
		} while (keuze < 1 || keuze > aantalKeuzes);

		return keuze;
	}

	private void drukOverzichtVoorstellingenAf() {
		System.out.println("Overzicht voorstellingen:");
		for (String voorstelling : dc.geefAlleVoorstellingen())
			System.out.println(voorstelling);
	}
	
	private void voegVoorstellingToe()
	{
		String[] gegevens;
		int keuze = maakKeuzeUitMenu(1);
		invoer.nextLine(); // vorige input nog wegwerken
		if (keuze == 1) // film
			gegevens = geefGegevensVanFilm();
		else // concert
			gegevens = geefGegevensVanConcert();
		dc.voegVoorstellingToe(gegevens);
	}

	private String[] geefGegevensVanFilm() {
				
		System.out.print("Geef de naam van de film: ");
		String naam = invoer.nextLine();
		
		System.out.print("Geef het jaar waarin de film uitkwam: ");
		String jaar = invoer.nextLine();
		
		System.out.print("Hoeveel sterren verdient deze film: ");
		String sterren = invoer.nextLine();
		
		return new String[] {naam, sterren, jaar};
	}
	
	private String[] geefGegevensVanConcert() {
		System.out.print("Geef de naam van de artiest: ");
		String artiest = invoer.nextLine();
		
		System.out.print("Geef de benaming van het concert: ");
		String naam = invoer.nextLine();
		
		return new String[] {artiest, naam};
	}
	
	private int geefAantalInZaal() {
		System.out.println("Geef het zaalnr: ");
		int keuze = maakKeuzeUitMenu(2);
		
		return dc.geefAantalInZaal(keuze);
	}

	private String[] geefKeuzeMenu(int nrMenu) {
		String[][] menu = {{"Toon het overzicht van de voorstellingen", "Voeg een voorstelling toe", 
			"Geef het aantal voorstellingen in een bepaalde zaal", "Beëindig het programma"},
			{"Voeg een film toe", "Voeg een concertregistratie toe", "Keer terug naar hoofdmenu"}, 
			{"Zaal 1", "Zaal 2", "Zaal 3", "Keer terug naar hoofdmenu"}};
		
		return menu[nrMenu];
	}
}
