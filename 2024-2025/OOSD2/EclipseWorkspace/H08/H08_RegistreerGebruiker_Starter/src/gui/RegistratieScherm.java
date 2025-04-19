package gui;

import domein.DomeinController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class RegistratieScherm extends GridPane {
	private DomeinController dc;

	public RegistratieScherm(DomeinController dc) {
		this.dc = dc;
		bouwGUI();
	}

	private void bouwGUI() {
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(30);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(70);
		this.getColumnConstraints().addAll(col1, col2);
		this.setAlignment(Pos.CENTER);
		this.setHgap(5);
		this.setVgap(15);
		this.setPadding(new Insets(20));

		TextField txfGebruikersnaam = new TextField();
		this.add(new Label("Gebruikersnaam:"), 0, 0);
		this.add(txfGebruikersnaam, 1, 0);

		TextField txfWachtwoord = new TextField();
		this.add(new Label("Wachtwoord:"), 0, 1);
		this.add(txfWachtwoord, 1, 1);

		TextField txfWachtwoordBevestiging = new TextField();
		this.add(new Label("Bevestig wachtwoord:"), 0, 2);
		this.add(txfWachtwoordBevestiging, 1, 2);

		Button btnRegistreer = new Button("Registreer");
		btnRegistreer.setMaxWidth(Double.MAX_VALUE);
		this.add(btnRegistreer, 0, 3, 2, 1);

		// TODO
		// Event handling btnRegistreer
		btnRegistreer.setOnAction((e) -> {
			try {
				dc.regsitreerGebruiker(txfGebruikersnaam.getText(), txfWachtwoord.getText(),
						txfWachtwoordBevestiging.getText());
				Alert confirmation = new Alert(AlertType.CONFIRMATION);
				confirmation.setTitle("Welkom");
				confirmation.setHeaderText("Welkom!");
				confirmation
						.setContentText(String.format("Welkom %s met wachtwoord %s%nJe bent succesvol geregistreerd!",
								dc.geefGebruikersnaam(), dc.geefWachtwoord()));
				confirmation.showAndWait();

			} catch (IllegalArgumentException ex) {
				Alert error = new Alert(AlertType.ERROR);
				error.setTitle("Error");
				error.setHeaderText("Error");
				error.setContentText(String.format("Gegevens zijn niet geldig!%n%s", ex.getMessage()));
				error.showAndWait();
			}
		});

	}

}
