package gui;

import domein.DomeinController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
		for (int i = 0; i < kenmerken.length; i++) {
			Label lblKenmerk = new Label(kenmerken[i]);
			TextField tfKenmerk = new TextField();
			txtKenmerken[i] = tfKenmerk;
			add(lblKenmerk, 0, i + 1, 1, 1);
			add(tfKenmerk, 2, i + 1, 2, 1);
		}
		// TODO buttons
		double btnWidthPref = 120;
		Button btnAdd = new Button("Voeg toe");
		btnAdd.setOnAction(e -> voegToe());
		btnAdd.setPrefWidth(btnWidthPref);
		add(btnAdd, 0, kenmerken.length + 2, 1, 1);
		Button btnCancel = new Button("Annuleer");
		btnCancel.setOnAction(e -> gaTerugNaarOverzichtsScherm());
		btnCancel.setPrefWidth(btnWidthPref);
		add(btnCancel, 2, kenmerken.length + 2, 1, 1);
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
		// TODO
		default -> dc.voegGebouwToe(txtKenmerken[0].getText(), Double.parseDouble(txtKenmerken[1].getText()));
		}
		} catch (NumberFormatException e) {
			signaliseerFout("Niet alle velden zijn correct ingevuld");
		}
		catch (IllegalArgumentException e) {
			signaliseerFout(e.getMessage());
			
		}
		overzichtsScherm.refresh();
		gaTerugNaarOverzichtsScherm();
	}

	private void signaliseerFout(String melding) {
		Alert alert = new Alert(AlertType.ERROR, melding);
		alert.showAndWait();
		
	}
}
