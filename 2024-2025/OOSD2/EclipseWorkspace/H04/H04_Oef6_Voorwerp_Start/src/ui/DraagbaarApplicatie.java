package ui;

import java.util.Scanner;

import domein.DomeinController;

public class DraagbaarApplicatie {
	private final DomeinController dc;

	public DraagbaarApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		dc.voegWapenToe("Colt", 1.5, 3, 6, false);
		dc.voegSleutelToe("Voordeur", 0.5, 3, 1);
		dc.voegWapenToe("Brown", 0.5, 1, 23, true);
		dc.voegSleutelToe("Achterdeur", 0.5, 1, 2);
		dc.voegGebouwToe("residentie Frankenstein", 4.5);

		System.out.printf("%s", dc.geefOverzicht());

		int keuze;
		do {
			keuze = geefKeuzeUitMenu();
			
			switch(keuze) {
			case 1 -> voegWapenToe();
			case 2 -> voegSleutelToe();
			case 3 -> voegGebouwToe();
			case 4 -> System.out.println(dc.geefOverzicht());
			case 5 -> System.out.println("BYE");
			}
			
		} while (keuze != 5);
		
		
	}

	private int geefKeuzeUitMenu() {
		Scanner input = new Scanner(System.in);
    	String[] menuOpties = new String[] {"Voeg wapen toe", "Voeg sleutel toe", "Voeg gebouw toe", "Toon huidig overzicht", "Beëindig deze applicatie"};
    	String menu = "Kies uit:";
    	for (int i = 0; i < menuOpties.length; i++) {
    		menu += String.format("%n%d. %s", i + 1, menuOpties[i]);
    	}
    	menu += String.format("%nJe keuze is: ");
    	
    	boolean valid = false;
    	int keuze = -1;

    	do {
    		try {
    		System.out.print(menu);
    		keuze = input.nextInt();
    		valid = keuze <= menuOpties.length && keuze > 0;
    		} catch (NumberFormatException e) {
    			System.out.println("Voer een geheel getal in");
    		}
    	}while (!valid);
    	return keuze;
    }
	
	private void voegWapenToe() {
		Scanner input = new Scanner(System.in);
		System.out.printf("Geef een naam (zonder spaties): ");
		String naam = input.nextLine();
		System.out.printf("%nGeef het gewicht: ");
		double gewicht = Double.parseDouble(input.nextLine());
		System.out.println("Geef het niveau: ");
		int niveau = Integer.parseInt(input.nextLine());
		System.out.println("Geef de kracht: ");
		int kracht = Integer.parseInt(input.nextLine());
		System.out.println("Werd het wapen reeds gebruikt (true/false)?: ");
		boolean gebruikt = Boolean.valueOf(input.nextLine());
		try {
		dc.voegWapenToe(naam, gewicht, niveau, kracht, gebruikt);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			voegWapenToe();
		}	
	}
	private void voegSleutelToe() {
		Scanner input = new Scanner(System.in);
		System.out.printf("Geef een naam (zonder spaties): ");
		String naam = input.nextLine();
		System.out.printf("%nGeef het gewicht: ");
		double gewicht = Double.parseDouble(input.nextLine());
		System.out.println("Geef het niveau: ");
		int niveau = Integer.parseInt(input.nextLine());
		System.out.println("Geef het nummer van de deur: ");
		int deur = Integer.parseInt(input.nextLine());

		try {
		dc.voegSleutelToe(naam, gewicht, niveau, deur);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			voegSleutelToe();
		}	
	}
	private void voegGebouwToe() {
		Scanner input = new Scanner(System.in);
		System.out.printf("Geef een naam (zonder spaties): ");
		String naam = input.nextLine();
		System.out.printf("%nGeef de hoogte: ");
		int hoogte = Integer.parseInt(input.nextLine());
		
		try {
			dc.voegGebouwToe(naam, hoogte);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			voegGebouwToe();
		}
	}
}
