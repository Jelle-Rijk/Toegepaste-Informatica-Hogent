package gui;

import domein.DomeinController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PalindroomScherm extends VBox {
	private DomeinController dc;
	private TextField txfIsPalindroom, txfKeerOm;
	private Label lblErrorMsg;

	public PalindroomScherm(DomeinController dc) {
		this.dc = dc;
		bouwGUI();
	}

	private void bouwGUI() {
		this.setPadding(new Insets(25));
		this.setSpacing(10);
		Label lblInvoer = new Label("Voer tekst in.");
		TextField txfInvoer = new TextField();
		Button btnKeerOm = new Button("Keer om!");
		txfKeerOm = new TextField();
		txfKeerOm.setEditable(false);
		Button btnIsPalindroom = new Button("Is palindroom?");
		txfIsPalindroom = new TextField();
		txfIsPalindroom.setEditable(false);
		lblErrorMsg = new Label();
		lblErrorMsg.setTextFill(Color.RED);
		lblErrorMsg.setStyle("-fx-font-weight: bold;");

		this.getChildren().addAll(lblInvoer, txfInvoer, btnKeerOm, txfKeerOm, btnIsPalindroom, txfIsPalindroom,
				lblErrorMsg);

		txfInvoer.setOnKeyTyped(evt -> {
			txfKeerOm.setText("");
			txfIsPalindroom.setText("");
			lblErrorMsg.setText("");
		});
		btnKeerOm.setOnAction(evt -> {
			doeKeerom(txfInvoer.getText());
		});
		btnIsPalindroom.setOnAction(evt -> {
			doeIsPalindroom(txfInvoer.getText());
		});
	}

	private void doeIsPalindroom(String tekst) {
		try {
			dc.maakDoosMetString(tekst);
			txfIsPalindroom.setText(
					String.format("'%s' is %seen palindroom...", dc.geefInhoud(), dc.bevatPalindroom() ? "" : "g"));

		} catch (Exception e) {
			lblErrorMsg.setText(e.getMessage());
		}

	}

	private void doeKeerom(String tekst) {
		try {
			dc.maakDoosMetString(tekst);
			txfKeerOm.setText(dc.geefOmgekeerdeInhoud());

		} catch (Exception e) {
			lblErrorMsg.setText(e.getMessage());
		}
	}
}
