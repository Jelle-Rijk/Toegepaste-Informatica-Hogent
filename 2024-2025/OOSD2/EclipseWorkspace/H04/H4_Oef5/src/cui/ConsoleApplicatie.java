package cui;

import java.util.NoSuchElementException;
import java.util.Scanner;

import domein.DomeinController;
import exceptions.NegativeNumberException;

public class ConsoleApplicatie {
	DomeinController dc;

	public ConsoleApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		boolean valid = false;
		double[] getallen = new double[2];
		double[] vierkantswortels = new double[2];

		do {
			try {
				System.out.print("Geef 2 positieve decimale getallen gescheiden door een spatie: ");
				String[] invoer = scanner.nextLine().split(" ");
//				System.out.println();
				
				if (invoer.length != 2)
					throw new NoSuchElementException();
				
			int index = 0;
				for (String s : invoer) {
					dc.startBerekeningVierkantswortel(Double.parseDouble(s));
					getallen[index] = dc.geefGetal();
					vierkantswortels[index] = dc.geefVierkantswortel();
					index++;
				}
				valid = true;
			} catch (NoSuchElementException e) {
				System.out.println("Er moeten 2 delen in de invoer zijn gescheiden door een spatie.");
			} catch (NumberFormatException e) {
				System.out.println("Beide delen moeten decimale getallen zijn.");
			}
			catch (NegativeNumberException e) {
				System.out.println("Het getal moet positief zijn.");
			}
		} while (!valid);
		
		for (int i = 0; i < getallen.length; i++) {
			System.out.printf("De vierkantswortel van %.2f is %.2f%n", getallen[i], vierkantswortels[i]);
		}
	}
}
