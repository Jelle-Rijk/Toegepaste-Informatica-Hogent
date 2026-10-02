package ui;

import domein.SportclubController;

public class ConsoleApplicatie {
	private SportclubController sportClubController;

	public ConsoleApplicatie(SportclubController sportClubController) {
		this.sportClubController = sportClubController;
		start();
	}

	private void start() {

//TODO uncomment OEF GENERICS
//		IO.println("\nOverzicht sporters per lidnummer:\n" + sportClubController.geefSportersPerLidnr());
//		IO.println("\nOverzicht sporters per aantal reductiebonnen\n"
//				+ sportClubController.geefSportersPerAantalReductiebonnen());
//		IO.println("\nOverzicht sporters:\n" + sportClubController.geefSporters());
	}

}
