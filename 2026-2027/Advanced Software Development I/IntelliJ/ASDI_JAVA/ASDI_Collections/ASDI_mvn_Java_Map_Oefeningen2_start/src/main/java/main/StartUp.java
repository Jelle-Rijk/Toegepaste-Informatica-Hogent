package main;

import domein.DomeinController;
import ui.BierApplicatie;

public class StartUp {
	public void main() {
		DomeinController dc = new DomeinController();
		new BierApplicatie(dc).run();
	}
}
