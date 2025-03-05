package gui;

import java.io.IOException;

import domein.DomeinController;
import dto.ContainerDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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
	    private Button btnNaarOverzicht;

	    @FXML
	    private Button btnVoegToe;

	    @FXML
	    private Label lblEigenaarOngeldig;

	    @FXML
	    private Label lblMassaOngeldig;

	    @FXML
	    private Label lblSerienummerOngeldig;

	    @FXML
	    private Label lblVolumeOngeldig;

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
	    		if (txfEigenaar.getText().isBlank())
	    			throw new Exception();
	    	} catch (Exception e) {
	    		lblEigenaarOngeldig.setText("Eigenaar moet ingevuld zijn");
	    	}
	    }

	    @FXML
	    void valideerMassa(KeyEvent event) {
	    	try {
	    	if (Integer.parseInt(txfMassa.getText()) <= 0)
	    		throw new Exception();
	    	lblMassaOngeldig.setText("");
	    	} catch (Exception e) {
	    		lblMassaOngeldig.setText("Ongeldige waarde");
	    	}
	    }

	    @FXML
	    void valideerSerienummer(KeyEvent event) {
	    	try {
	    	if (Integer.parseInt(txfSerienummer.getText()) <= 0)
	    		throw new Exception();
	    	lblSerienummerOngeldig.setText("");
	    	} catch (Exception e) {
	    		lblSerienummerOngeldig.setText("Ongeldige waarde");
	    	}
	    }

	    @FXML
	    void valideerVolume(KeyEvent event) {
	    	try {
	    	if (Integer.parseInt(txfVolume.getText()) <= 0)
	    		throw new Exception();
	    	lblVolumeOngeldig.setText("");
	    	} catch (Exception e) {
	    		lblVolumeOngeldig.setText("Ongeldige waarde");
	    	}
	    }

	    @FXML
	    void voegToe(ActionEvent event) {
	    	String eigenaar = txfEigenaar.getText();
	    	int massa = Integer.parseInt(txfMassa.getText());
	    	int volume= Integer.parseInt(txfVolume.getText());
	    	int serienummer= Integer.parseInt(txfSerienummer.getText());
	    	
	    	try {
	    		dc.voegContainerToe(new ContainerDTO(eigenaar, massa, volume, serienummer));	    		
	    		
	    		Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setHeaderText(String.format("Container met serienummer %d werd succesvol toegevoegd.", serienummer));
	    		alert.showAndWait();
	    		
	    		for (TextField txf : new TextField[] {txfEigenaar, txfMassa, txfVolume, txfSerienummer})
	    			txf.setText("");
	    
	    	} catch (Exception e) {
	    		toonFoutmelding(e.getMessage());
	    	}
	    	
	    }
	
	
}
