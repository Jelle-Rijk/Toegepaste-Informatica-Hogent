package ui;

import java.util.Scanner;

import domein.SportclubController;

public class ConsoleApplicatie {
	private SportclubController sportClubController;

	public ConsoleApplicatie(SportclubController sportClubController) {
		this.sportClubController = sportClubController;
		start();
	}

	private void start() {
//		try (Scanner input = new Scanner(System.in)) {
//			System.out.print("Geef het id van sporter: ");
//			int sporterLidNr = input.nextInt();
//			System.out.printf("\nalle sporters met gelijk aantal reductiebonnen als lidNummer %s : %s%n",
//					sporterLidNr, sportClubController.geefSportersMetEvenveelReductiebonnen(sporterLidNr));
//		}


		IO.println("\nOverzicht sporters per lidnummer:\n" + sportClubController.geefSportersPerLidnr());
		IO.println("\nOverzicht sporters per aantal reductiebonnen\n"
				+ sportClubController.geefSportersPerAantalReductiebonnen());
		IO.println("\nOverzicht sporters:\n" + sportClubController.geefSporters());
		
		
	}

}
