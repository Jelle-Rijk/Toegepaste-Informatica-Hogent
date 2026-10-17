package main;

import domein.BonController;
import domein.SportclubController;
import ui.ConsoleApplicatie;

public class StartUp {
	public void main() {
		
//		new ConsoleApplicatie(new SportclubController());

		BonController bc = new BonController();
		bc.init();
	}
}
