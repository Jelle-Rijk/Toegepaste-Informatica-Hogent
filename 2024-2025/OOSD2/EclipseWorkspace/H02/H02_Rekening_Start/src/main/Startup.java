package main;

import domein.DomeinController;
import ui.KostenApplicatie;

public class Startup {
	public static void main (String[] args) {
		new KostenApplicatie(new DomeinController()).werkMetKosten();
	}
}
