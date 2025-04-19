package gui;

import domein.DomeinController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class LetterRapportScherm extends VBox {
	private DomeinController dc;
	private Label lblErrorMessage;

	public LetterRapportScherm(DomeinController dc) {
		this.dc = dc;
		bouwGUI();
	}

	private void bouwGUI() {
		this.setSpacing(10);
		this.setPadding(new Insets(20));

		Label lblInvoer = new Label("Geef zin op");
		TextField txfZin = new TextField();
		Button btnRapport = new Button("Toon letter rapport");
		TextArea txaResultaat = new TextArea();
		txaResultaat.setEditable(false);
		txaResultaat.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 14));
		btnRapport.setOnAction(e -> toonLetterRapport(txfZin.getText(), txaResultaat));
		txfZin.setOnKeyTyped(evt -> {
			lblErrorMessage.setText("");
			txaResultaat.setText("");
		});

		this.getChildren().addAll(lblInvoer, txfZin, btnRapport, txaResultaat);

		lblErrorMessage = new Label();
		lblErrorMessage.setTextFill(Color.RED);
		lblErrorMessage.setStyle("-fx-font-weight: bold;");
		this.getChildren().add(lblErrorMessage);
	}

	private void toonLetterRapport(String zin, TextArea resultaat) {
		try {
			lblErrorMessage.setText("");
			dc.maakDoosMetString(zin);
			resultaat.setText(dc.geefLetterRapport());
		} catch (Exception e) {
			lblErrorMessage.setText(e.getMessage());
		}
	}
}
