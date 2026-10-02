package main;

import domein.SportclubController;
import ui.ConsoleApplicatie;

public class StartUp {
	public void main() {
		new ConsoleApplicatie(new SportclubController());
	}

}
