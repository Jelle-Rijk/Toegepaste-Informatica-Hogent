package cui;

import java.util.Scanner;

public class Menu {
	private static Scanner invoer = new Scanner(System.in);

	public static int geefKeuzeUitMenu(String[] keuzes) {
		int keuze = -1;
		boolean invoerOK = false;
		do {
			toonMenu(keuzes);
			keuze = invoer.nextInt();
			invoerOK = true;
		} while (!invoerOK);
		return keuze;
	}

	private static void toonMenu(String[] keuzes) {
		System.out.println("MENU");
		System.out.println("====");
		for (int i = 0; i < keuzes.length; i++) {
			System.out.printf("%d. %s%n", i + 1, keuzes[i]);
		}
		System.out.print("Voer je keuze in: ");
	}
}
