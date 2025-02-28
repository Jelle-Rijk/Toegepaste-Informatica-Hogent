package main;

import domein.DomeinController;
import ui.ContainerApp;

public class StartUp {

	public static void main(String[] args) {
		new ContainerApp(new DomeinController()).start();
	}

}
