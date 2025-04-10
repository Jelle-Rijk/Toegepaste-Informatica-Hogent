package main;

import domein.DomeinController;
import ui.BierApplicatie;

public class StartUp {
	public static void main(String[] args) {
		new BierApplicatie(new DomeinController()).start();
	}
}
