package gui;

import domein.DomeinController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.DraagbaarType;

public class ToevoegScherm extends GridPane {
	private DomeinController dc;
	private TextField[] txtKenmerken;
	private DraagbaarType draagbaarType;
	private OverzichtsScherm overzichtsScherm;

	public ToevoegScherm(DomeinController dc, DraagbaarType dt, OverzichtsScherm overzichtsScherm) {
		this.dc = dc;
		this.overzichtsScherm = overzichtsScherm;
		this.draagbaarType = dt;
		buildGui(dt.getKenmerken());
	}

	private void buildGui(String[] kenmerken) {
		setPadding(new Insets(20));
		setVgap(10);
		setHgap(10);
		setAlignment(Pos.TOP_CENTER);
		Label lblTitel = new Label(String.format("%s toevoegen", draagbaarType.name()));
		setHalignment(lblTitel, HPos.CENTER);
		lblTitel.setFont(Font.font("Montserrat", FontWeight.NORMAL, 20));
		add(lblTitel, 0, 0, 2, 1);
		txtKenmerken = new TextField[kenmerken.length];

		// TODO labels en textfields voor alle kenmerken
		int rij = 1;
		for (String kenmerk : kenmerken) {
			Label lblKenmerk = new Label(kenmerk);
			TextField txfKenmerk = new TextField();
			txtKenmerken[rij - 1] = txfKenmerk;
			add(lblKenmerk, 0, rij);
			add(txfKenmerk, 1, rij);
			rij++;
		}

		// TODO buttons
		Button btnVoegToe = new Button("Voeg toe");
		btnVoegToe.setPrefWidth(100);
		Button btnAnnuleer = new Button("Annuleer");
		btnAnnuleer.setPrefWidth(100);
		add(btnVoegToe, 0, rij);
		add(btnAnnuleer, 1, rij);
		btnVoegToe.setOnAction(e -> voegToe());
		btnAnnuleer.setOnAction(e -> gaTerugNaarOverzichtsScherm());
		setHalignment(btnAnnuleer, HPos.RIGHT);
	}

	private void gaTerugNaarOverzichtsScherm() {
		getScene().setRoot(overzichtsScherm);
	}

	private void voegToe() {
		try {
			switch (draagbaarType) {
			case WAPEN -> dc.voegWapenToe(txtKenmerken[0].getText(), Double.parseDouble(txtKenmerken[1].getText()),
					Integer.parseInt(txtKenmerken[2].getText()), Integer.parseInt(txtKenmerken[3].getText()),
					txtKenmerken[4].getText().toLowerCase().equals("ja"));
			case SLEUTEL -> dc.voegSleutelToe(txtKenmerken[0].getText(), Double.parseDouble(txtKenmerken[1].getText()),
					Integer.parseInt(txtKenmerken[2].getText()), Integer.parseInt(txtKenmerken[3].getText()));
			default -> dc.voegGebouwToe(txtKenmerken[0].getText(), Double.parseDouble(txtKenmerken[1].getText()));
			}
			overzichtsScherm.refresh();
			gaTerugNaarOverzichtsScherm();
		} catch (NumberFormatException e) {
			signaliseerFout("Niet alle velden zijn correct ingevuld");
		} catch (IllegalArgumentException e) {
			signaliseerFout(e.getMessage());
		}
	}

	private void signaliseerFout(String melding) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Er ging iets mis...");
		alert.setContentText(melding);

		alert.showAndWait();
	}
}
