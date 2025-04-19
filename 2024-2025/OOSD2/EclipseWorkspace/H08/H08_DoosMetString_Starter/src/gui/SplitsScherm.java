package gui;

import domein.DomeinController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SplitsScherm extends GridPane {
	private DomeinController dc;
	private TextField txfSplits;
	private Label lblErrorMessage;
	private VBox vBoxResult;

	public SplitsScherm(DomeinController dc) {
		this.dc = dc;
		bouwGUI();
	}

	private void bouwGUI() {
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(70);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(30);
		this.getColumnConstraints().addAll(col1, col2);

		this.setHgap(5);
		this.setVgap(5);
		this.setPadding(new Insets(20));

		Label lblInvoer = new Label("Geef zin op");
		TextField txfZin = new TextField();
		this.add(lblInvoer, 0, 0, 2, 1);
		this.add(txfZin, 0, 1, 2, 1);
		Label lblSplits = new Label("Geef woord om te splitsen");
		txfSplits = new TextField();
		this.add(lblSplits, 0, 2);
		this.add(txfSplits, 1, 2);
		GridPane.setHalignment(lblSplits, HPos.RIGHT);

		Button btnSplits = new Button("Splits zin op");
		this.add(btnSplits, 0, 4);
		vBoxResult = new VBox();
		vBoxResult.setStyle("-fx-border-color: black;-fx-border-width: 1;-fx-border-style: solid;");
		vBoxResult.setPadding(new Insets(5));
		this.add(vBoxResult, 0, 5, 2, 1);
		btnSplits.setOnAction(e -> toonZinsdelen(txfZin.getText()));

		lblErrorMessage = new Label();
		lblErrorMessage.setTextFill(Color.RED);
		lblErrorMessage.setStyle("-fx-font-weight: bold;");
		txfSplits.setOnKeyTyped(evt -> wisZinsdelen());
		txfZin.setOnKeyTyped(evt -> wisZinsdelen());

		this.add(lblErrorMessage, 0, 6, 2, 1);
	}

	private void toonZinsdelen(String zin) {
		try {
			lblErrorMessage.setText("");
			vBoxResult.getChildren().clear();
			dc.maakDoosMetString(zin);
			if (txfSplits.getText().isEmpty())
				throw new IllegalArgumentException("Geef een splits woord op");
			String[] zinsdelen = dc.geefGesplitsteZin(txfSplits.getText());
			for (int i = 0; i < zinsdelen.length; i++) {
				String string = zinsdelen[i];
				vBoxResult.getChildren().add(new Label(string));
			}
		} catch (Exception e) {
			lblErrorMessage.setText(e.getMessage());
		}
	}

	private void wisZinsdelen() {
		lblErrorMessage.setText("");
		vBoxResult.getChildren().clear();
	}
}
