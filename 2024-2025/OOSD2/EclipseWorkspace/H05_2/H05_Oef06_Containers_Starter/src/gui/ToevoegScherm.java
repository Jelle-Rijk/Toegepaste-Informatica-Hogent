package gui;

import java.io.IOException;

import domein.DomeinController;
import dto.ContainerDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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

	@FXML
	private Label lblEigenaar;

	@FXML
	private Label lblEigenaarFeedback;

	@FXML
	private Label lblMassa;

	@FXML
	private Label lblMassaFeedback;

	@FXML
	private Label lblSerienummer;

	@FXML
	private Label lblSerienummerFeedback;

	@FXML
	private Label lblVolume;

	@FXML
	private Label lblVolumeFeedback;

	@FXML
	private TextField txfEigenaar;

	@FXML
	private TextField txfMassa;

	@FXML
	private TextField txfSerienummer;

	@FXML
	private TextField txfVolume;

	@FXML
	void gaTerugNaarOverzicht(ActionEvent event) {
		overzichtsScherm.show();
	}

	@FXML
	void valideerEigenaar(KeyEvent event) {
		try {
			String input = txfEigenaar.getText();
			if (input == null || input.isBlank())
				throw new IllegalArgumentException("");
			lblEigenaarFeedback.setText("Invoer is OK");
		} catch (Exception e) {
			lblEigenaarFeedback.setText("Ongeldige waarde");
		}
	}

	@FXML
	void valideerMassa(KeyEvent event) {
		try {
			if (Integer.parseInt(txfMassa.getText()) < 0)
				throw new IllegalArgumentException();
			lblMassaFeedback.setText("Invoer is OK");
		} catch (Exception e) {
			lblMassaFeedback.setText("Ongeldige waarde");
		}
	}

	@FXML
	void valideerSerienummer(KeyEvent event) {
		try {
			if (Integer.parseInt(txfSerienummer.getText()) < 0)
				throw new IllegalArgumentException();
			lblSerienummerFeedback.setText("Invoer is OK");
		} catch (Exception e) {
			lblSerienummerFeedback.setText("Ongeldige waarde");
		}
	}

	@FXML
	void valideerVolume(KeyEvent event) {
		try {
			if (Integer.parseInt(txfVolume.getText()) < 0)
				throw new IllegalArgumentException();
			lblVolumeFeedback.setText("Invoer is OK");
		} catch (Exception e) {
			lblVolumeFeedback.setText("Ongeldige waarde");
		}
	}

	@FXML
	void voegToe(ActionEvent event) {
		try {
			dc.voegContainerToe(new ContainerDTO(txfEigenaar.getText(), Integer.parseInt(txfMassa.getText()),
					Integer.parseInt(txfVolume.getText()), Integer.parseInt(txfSerienummer.getText())));
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(
					String.format("Container met serienummer %s werd succesvol toegevoegd.", txfSerienummer.getText()));
			for (TextField txf : new TextField[] { txfEigenaar, txfMassa, txfSerienummer, txfVolume }) {
				txf.clear();
			}

			alert.showAndWait();
		} catch (Exception e) {
			toonFoutmelding(e.getMessage());
		}
	}
}
