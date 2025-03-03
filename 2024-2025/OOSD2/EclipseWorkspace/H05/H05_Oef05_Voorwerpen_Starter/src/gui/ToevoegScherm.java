package gui;

import domein.DomeinController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
		// TODO buttons
	}

	private void gaTerugNaarOverzichtsScherm() {
		// TODO
	}

	private void voegToe() {
		switch (draagbaarType) {
		case WAPEN -> dc.voegWapenToe(txtKenmerken[0].getText(), Double.parseDouble(txtKenmerken[1].getText()),
				Integer.parseInt(txtKenmerken[2].getText()), Integer.parseInt(txtKenmerken[3].getText()),
				txtKenmerken[4].getText().toLowerCase().equals("ja"));
		case SLEUTEL -> dc.voegSleutelToe(txtKenmerken[0].getText(), Double.parseDouble(txtKenmerken[1].getText()),
				Integer.parseInt(txtKenmerken[2].getText()), Integer.parseInt(txtKenmerken[3].getText()));
		// TODO
		default -> throw new IllegalArgumentException("This is a TO DO!");
		}
		overzichtsScherm.refresh();
		gaTerugNaarOverzichtsScherm();
	}

	private void signaliseerFout(String melding) {
		System.out.println("TODO"); // TODO
	}
}
