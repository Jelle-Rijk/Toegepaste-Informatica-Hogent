package main;

import domein.DomeinController;
import ui.VoorwerpApp;

public class Startup {

	public static void main(String[] args) {
		new VoorwerpApp(new DomeinController()).start();
	}

}
