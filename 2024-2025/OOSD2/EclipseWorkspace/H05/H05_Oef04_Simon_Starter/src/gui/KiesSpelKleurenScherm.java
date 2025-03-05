package gui;

import java.util.ArrayList;
import java.util.List;

import domein.DomeinController;
import domein.Simon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.Kleur;

public class KiesSpelKleurenScherm extends VBox {
	private final DomeinController dc;
	private Kleur[] gekozenKleuren;
	private Label lblFeedback;

	public KiesSpelKleurenScherm(DomeinController dc) {
		this.dc = dc;
		gekozenKleuren = new Kleur[Simon.AANTAL_KLEUREN];
		bouwScherm();
	}

	private void bouwScherm() {
		Label lblTitel = new Label(String.format("Kies de %d kleuren", Simon.AANTAL_KLEUREN));
		List<String> kleurStrings = new ArrayList<String>();
		for (Kleur k : Kleur.values()) {
			kleurStrings.add(k.toString());
		}
		getChildren().add(lblTitel);
		lblTitel.setFont(Font.font("Montserrat", FontWeight.BOLD, 24));

		for (int i = 0; i < Simon.AANTAL_KLEUREN; i++) {
			final int kleurIndex = i;
			ComboBox<String> cmbKleuren = new ComboBox<String>();
			cmbKleuren.getItems().addAll(kleurStrings);
			cmbKleuren.setOnAction(e -> registreerKleur(kleurIndex, cmbKleuren.getSelectionModel().getSelectedItem()));
			getChildren().add(cmbKleuren);
		}
		
		Button btnStart = new Button("Start spel");
		lblFeedback = new Label();
		btnStart.setOnAction(e -> startSpel());
		getChildren().addAll(btnStart, lblFeedback);

		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(10,10,10,10));
		this.setSpacing(10);
	}

	private void startSpel() {
		try {
			dc.startNieuwSpel(gekozenKleuren);
			getScene().setRoot(new ToonNieuweKleurScherm(dc));
		} catch (Exception e) {
			lblFeedback.setText(e.getMessage());
		}
	}

	private void registreerKleur(int kleurIndex, String selectedItem) {
		gekozenKleuren[kleurIndex] = Kleur.valueOf(selectedItem);
		lblFeedback.setText("");
	}

}
