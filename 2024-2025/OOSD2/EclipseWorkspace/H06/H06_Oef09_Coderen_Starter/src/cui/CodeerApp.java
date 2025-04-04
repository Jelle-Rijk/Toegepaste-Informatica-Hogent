package cui;

import java.util.Scanner;

import utils.Codeerder;

public class CodeerApp {
	public void start() {
		Scanner invoer = new Scanner(System.in);
		System.out.println("Geef een zin op: ");
		String zin = invoer.nextLine();
		System.out.printf("De gecodeerde zin is '%s'", Codeerder.codeer(zin));

	}
}
