package gui;

import domein.DomeinController;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;

public class StartScherm extends BorderPane {
	private DomeinController dc;

	public StartScherm(DomeinController dc) {
		this.dc = dc;
		bouwGUI();
	}

	private void bouwGUI() {
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Oefening");

		MenuItem item = new MenuItem("Palindroom");
		item.setOnAction(e -> this.setCenter(new PalindroomScherm(dc)));
		menu.getItems().add(item);

		item = new MenuItem("Wartaal");
		item.setOnAction(e -> this.setCenter(new WartaalScherm(dc)));
		menu.getItems().add(item);

		item = new MenuItem("Validatie");
		item.setOnAction(e -> this.setCenter(new ValidatieScherm(dc)));
		menu.getItems().add(item);

		item = new MenuItem("Zin opsplitsen");
		item.setOnAction(e -> this.setCenter(new SplitsScherm(dc)));
		menu.getItems().add(item);

		item = new MenuItem("Letter rapport");
		item.setOnAction(e -> this.setCenter(new LetterRapportScherm(dc)));
		menu.getItems().add(item);

		menu.getItems().add(new SeparatorMenuItem());

		item = new MenuItem("Exit");
		item.setOnAction(e -> Platform.exit());
		menu.getItems().add(item);

		menuBar.getMenus().add(menu);
		this.setTop(menuBar);
		this.setCenter(new PalindroomScherm(dc));
	}
}
