package gui;

import domein.DomeinController;
import domein.Simon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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
		Label lblTitel = new Label("Kies de 4 kleuren");
		lblTitel.setStyle("-fx-font-size: 24");
		getChildren().add(lblTitel);

		for (int i = 0; i < Simon.AANTAL_KLEUREN; i++) {
			ComboBox<String> cboKleuren = new ComboBox<String>();
			for (Kleur kleur : Kleur.values())
				cboKleuren.getItems().add(kleur.toString());
			final int kleurIndex = i;
			cboKleuren
					.setOnAction(evt -> registreerKleur(kleurIndex, cboKleuren.getSelectionModel().getSelectedItem()));
			getChildren().add(cboKleuren);
		}

		Button btnStart = new Button("Start spel");
		btnStart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				startSpel();
			}
		});
		lblFeedback = new Label();

		getChildren().addAll(btnStart, lblFeedback);
		setAlignment(Pos.CENTER);
		setSpacing(10);
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
	}

}
