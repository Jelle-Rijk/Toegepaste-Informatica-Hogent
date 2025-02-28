package main;

import domein.DomeinController;
import ui.ThermometerApplicatie;

public class StartUp {

	public static void main(String[] args) {
		new ThermometerApplicatie(new DomeinController()).start();
	}

}
