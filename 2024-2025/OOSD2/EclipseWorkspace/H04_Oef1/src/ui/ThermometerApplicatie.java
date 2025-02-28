package ui;

import java.util.Scanner;

import domein.DomeinController;

public class ThermometerApplicatie {
	private DomeinController dc;

	public ThermometerApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		int minF = 14, maxF = 104;

		Scanner s = new Scanner(System.in);
		boolean valid = false;
		do {
			try {
				System.out.printf("Geef een gehele temperatuur in °F uit het interval [%d,%d]: ", minF, maxF);
				int tempF = Integer.parseInt(s.nextLine());
				if (tempF > maxF || tempF < minF) {
					throw new IndexOutOfBoundsException();
				}
				valid = true;
				dc.updateTemperatuur(tempF);
			} catch (IndexOutOfBoundsException e) {
				System.out.printf("De waarde van temperatuur moet uit het interval [%d,%d] komen!%n", minF, maxF);
			} catch (IllegalArgumentException e) {
				System.out.println("De invoer moet een geheel getal zijn!");
			}
		} while (!valid);
		
		System.out.printf("De temperatuur in °C is %d", dc.geefTemperatuurInCelsius());

	}

}
