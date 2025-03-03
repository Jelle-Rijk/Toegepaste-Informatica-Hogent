package gui;

import java.io.IOException;

import domein.DomeinController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;

public class ToevoegScherm extends GridPane {
	private DomeinController dc;
	private OverzichtsScherm overzichtsScherm;

	public ToevoegScherm(DomeinController dc, OverzichtsScherm overzichtsScherm) {
		this.dc = dc;
		this.overzichtsScherm = overzichtsScherm;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ToevoegScherm.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	private void toonFoutmelding(String melding) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText("Container kan niet toegevoegd worden");
		alert.setContentText(melding);
		alert.showAndWait();
	}
}
