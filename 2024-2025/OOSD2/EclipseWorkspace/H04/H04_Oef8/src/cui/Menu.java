package cui;

import java.util.Scanner;

public class Menu {
	static Scanner invoer = new Scanner(System.in);
	
	public static int geefKeuzeUitMenu (String[] keuzes) throws IndexOutOfBoundsException, NumberFormatException{
		System.out.print("Voer je keuze in: ");
		int keuze = Integer.parseInt(invoer.nextLine());
		if (keuze < 1 || keuze > keuzes.length)
			throw new IndexOutOfBoundsException(String.format("Keuze moet tussen 1 en %d liggen.", keuzes.length));
		return keuze;
	};

	public static void toonMenu(String[] keuzes) {
		String menu = String.format("%nMENU%n====");
		for (int i = 0; i < keuzes.length; i++) {
			menu += String.format("%n%d. %s", i + 1, keuzes[i]);
		}

		System.out.println(menu);
	}

}
