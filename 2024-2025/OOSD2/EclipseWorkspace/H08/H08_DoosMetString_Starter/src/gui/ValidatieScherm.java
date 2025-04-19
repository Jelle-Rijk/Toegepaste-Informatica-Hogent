package gui;

import domein.DomeinController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import utils.Validator;

public class ValidatieScherm extends GridPane {
	private static final int POSTCODE = 0;
	private static final int HUISNUMMER = 1;
	private static final int EMAIL = 2;
	private static final int NAAM = 3;
	private DomeinController dc;
	private TextField txfPostcode, txfHuisnummer, txfEmail, txfNaam;

	public ValidatieScherm(DomeinController dc) {
		this.dc = dc;
		bouwGUI();
	}

	private void bouwGUI() {
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(20);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(50);
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setPercentWidth(30);
		this.getColumnConstraints().addAll(col1, col2);

		this.setHgap(5);
		this.setVgap(15);
		this.setPadding(new Insets(20));

		Label lblInvoer = new Label("Postcode:");
		txfPostcode = new TextField();
		Label lblValideerPostcode = new Label("ONGELDIG");
		lblValideerPostcode.setStyle("-fx-text-fill: red;-fx-font-weight:bold");
		txfPostcode.setOnKeyTyped(e -> validate(POSTCODE, txfPostcode, lblValideerPostcode));
		this.add(lblInvoer, 0, 0);
		this.add(txfPostcode, 1, 0);
		this.add(lblValideerPostcode, 2, 0);

		lblInvoer = new Label("Huisnummer:");
		txfHuisnummer = new TextField();
		Label lblValideerHuisnummer = new Label("ONGELDIG");
		lblValideerHuisnummer.setStyle("-fx-text-fill: red;-fx-font-weight:bold");
		txfHuisnummer.setOnKeyTyped(e -> validate(HUISNUMMER, txfHuisnummer, lblValideerHuisnummer));
		this.add(lblInvoer, 0, 1);
		this.add(txfHuisnummer, 1, 1);
		this.add(lblValideerHuisnummer, 2, 1);

		lblInvoer = new Label("Naam:");
		txfNaam = new TextField();
		Label lblValideerNaam = new Label("ONGELDIG");
		lblValideerNaam.setStyle("-fx-text-fill: red;-fx-font-weight:bold");
		txfNaam.setOnKeyTyped(e -> validate(NAAM, txfNaam, lblValideerNaam));
		this.add(lblInvoer, 0, 2);
		this.add(txfNaam, 1, 2);
		this.add(lblValideerNaam, 2, 2);

		lblInvoer = new Label("E-mail:");
		txfEmail = new TextField();
		Label lblValideerEmail = new Label("ONGELDIG");
		lblValideerEmail.setStyle("-fx-text-fill: red;-fx-font-weight:bold");
		txfEmail.setOnKeyTyped(e -> validate(EMAIL, txfEmail, lblValideerEmail));
		this.add(lblInvoer, 0, 3);
		this.add(txfEmail, 1, 3);
		this.add(lblValideerEmail, 2, 3);

	}

	private void validate(int keuze, TextField invoer, Label validatie) {
		boolean resultaat = switch (keuze) {
		case POSTCODE -> Validator.validatePostcode(invoer.getText());
		case HUISNUMMER -> Validator.validateHuisnummer(invoer.getText());
		case NAAM -> Validator.validateNaam(invoer.getText());
		case EMAIL -> Validator.validateEmail(invoer.getText());
		default -> {
			yield false;
		}
		};
		if (resultaat) {
			validatie.setText("GELDIG");
			validatie.setStyle("-fx-text-fill: green;-fx-font-weight:bold");
		} else {
			validatie.setText("ONGELDIG");
			validatie.setStyle("-fx-text-fill: red;-fx-font-weight:bold");
		}
	}
}
