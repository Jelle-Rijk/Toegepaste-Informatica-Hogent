package gui;

import domein.DomeinController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class WartaalScherm extends GridPane {
	private DomeinController dc;
	private TextField txfWartaal, txfLetter1, txfLetter2;
	private Label lblErrorMessage;

	public WartaalScherm(DomeinController dc) {
		this.dc = dc;
		bouwGUI();
	}

	private void bouwGUI() {
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(90);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(10);
		this.getColumnConstraints().addAll(col1, col2);

		this.setHgap(5);
		this.setVgap(5);
		this.setPadding(new Insets(20));

		Label lblInvoer = new Label("Geef zin op");
		TextField txfZin = new TextField();
		this.add(lblInvoer, 0, 0, 2, 1);
		this.add(txfZin, 0, 1, 2, 1);
		txfZin.setOnKeyTyped(evt -> wisWartaal());

		Label lblLetter1 = new Label("Welke letter wil je vervangen?");
		Label lblLetter2 = new Label("Door welke letter wil je die vervangen?");
		txfLetter1 = new TextField();
		txfLetter2 = new TextField();
		txfLetter1.setOnKeyTyped(evt -> wisWartaal());
		txfLetter2.setOnKeyTyped(evt -> wisWartaal());

		this.add(lblLetter1, 0, 2);
		this.add(txfLetter1, 1, 2);
		this.add(lblLetter2, 0, 3);
		this.add(txfLetter2, 1, 3);
		GridPane.setHalignment(lblLetter1, HPos.RIGHT);
		GridPane.setHalignment(lblLetter2, HPos.RIGHT);

		Button btnWartaal = new Button("Maak wartaal");
		this.add(btnWartaal, 0, 4);
		txfWartaal = new TextField();
		this.add(txfWartaal, 0, 5, 2, 1);
		btnWartaal.setOnAction(e -> toonWartaal(txfZin.getText()));

		lblErrorMessage = new Label();
		lblErrorMessage.setTextFill(Color.RED);
		lblErrorMessage.setStyle("-fx-font-weight: bold;");
		this.add(lblErrorMessage, 0, 6, 2, 1);
	}

	private void toonWartaal(String zin) {
		try {
			lblErrorMessage.setText("");
			dc.maakDoosMetString(zin);
			if (txfLetter1.getText().isEmpty() || txfLetter2.getText().isEmpty())
				throw new IllegalArgumentException("Geef beide letters op!");
			txfWartaal.setText(dc.geefWartaal(txfLetter1.getText().charAt(0), txfLetter2.getText().charAt(0)));
		} catch (Exception e) {
			lblErrorMessage.setText(e.getMessage());
		}
	}

	private void wisWartaal() {
		lblErrorMessage.setText("");
		txfWartaal.setText("");
	}
}
