package main;

import cui.ConsoleApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		new ConsoleApplicatie(new DomeinController()).start();
	}

}
