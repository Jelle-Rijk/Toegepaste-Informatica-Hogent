package ui;

import java.util.Scanner;

import domein.DomeinController;
import dto.VertoonbaarDTO;

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
			keuze = Integer.parseInt(invoer.nextLine());
		} while (keuze < 1 || keuze > aantalKeuzes);

		return keuze;
	}

	private void drukOverzichtVoorstellingenAf() {
		System.out.println("Overzicht voorstellingen:");
		for (VertoonbaarDTO v : dc.geefAlleVoorstellingen())
		{
			switch (v.soort())
			{
				case 'F' -> System.out.printf("Film %s - %d - %d", v.naam(), v.sterren(), v.jaar()); 
				case 'C' -> System.out.printf("Concertregistratie %s van %s", v.concertNaam(), v.artiest());
			};
			System.out.printf(" in zaal %d%n", v.zaal());
		}
	}
	
	private void voegVoorstellingToe()
	{
		int keuze = maakKeuzeUitMenu(1);
		if (keuze == 1) // film
			voegFilmToe();
		else if (keuze == 2) // concert
			voegConcertToe();
		
	}

	private void voegFilmToe() {
		System.out.print("Geef de naam van de film: ");
		String naam = invoer.nextLine();
		
		System.out.print("Geef het jaar waarin de film uitkwam: ");
		int jaar = Integer.parseInt(invoer.nextLine());;
		
		System.out.print("Hoeveel sterren verdient deze film: ");
		int sterren = Integer.parseInt(invoer.nextLine());;
		
		dc.voegVoorstellingToe(naam, sterren, jaar);
	}
	
	private void voegConcertToe() {
		System.out.print("Geef de naam van de artiest: ");
		String artiest = invoer.nextLine();
		
		System.out.print("Geef de benaming van het concert: ");
		String naam = invoer.nextLine();
		
		dc.voegVoorstellingToe(artiest, naam);
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