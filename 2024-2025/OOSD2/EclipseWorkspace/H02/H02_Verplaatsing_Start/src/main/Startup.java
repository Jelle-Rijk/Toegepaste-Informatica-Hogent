package main;

import domein.DomeinController;
import ui.KostenApp;

public class Startup {

	public static void main(String[] args) {
		new KostenApp(new DomeinController()).start();
	}

}
