package main;

import domein.DomeinController;
import ui.GarageApp;

public class StartUp {

	public static void main(String[] args) {
		new GarageApp(new DomeinController()).start();
	}

}
