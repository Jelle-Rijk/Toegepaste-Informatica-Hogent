package gui;

import java.util.ArrayList;
import java.util.List;

import domein.DomeinController;
import dto.BeheerskostDTO;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class BeheersKostenScherm extends VBox {
	private final DomeinController dc;
	private ComboBox<String> cboTitels;
	
	TextArea txaDetails;
	TextArea txaKost;

	public BeheersKostenScherm(DomeinController dc) {
		this.dc = dc;
		buildGui();
	}

	private void buildGui() {
		this.setPadding(new Insets(20));

		// ComboBox met titels van alle beheerskosten, prompt instellen en event handler
		// instellen
		cboTitels = new ComboBox<>();
		cboTitels.setItems(FXCollections.observableList(geefAlleTitels(dc.geefAlleBeheerskosten())));
		cboTitels.setPromptText("Over welk item wil je meer weten?");
		cboTitels.setOnAction(evt -> toonDetailsBeheerskost(cboTitels.getSelectionModel().getSelectedIndex()));

		// TODO Label en TextArea voor Details
		Label lblDetails = new Label("Details");
		lblDetails.setPadding(new Insets(20, 0, 0, 0));
		txaDetails = new TextArea();
		txaDetails.setEditable(false);
		txaDetails.setWrapText(true);
		

		// TODO Label & TextField voor Kost
		Label lblKost = new Label("Kost");
		lblKost.setPadding(new Insets(20, 0, 0, 0));
		txaKost = new TextArea();
		txaKost.setEditable(false);
		txaKost.setWrapText(true);

		// TODO Alle items in correcte volgorde toevoegen
		this.getChildren().addAll(cboTitels, lblDetails, txaDetails, lblKost, txaKost);
	}

	// Aangeroepen door de event handler van de combobox
	private void toonDetailsBeheerskost(int index) {
		BeheerskostDTO kost = dc.geefAlleBeheerskosten().get(index);
		txaDetails.setText(geefDetails(kost));
		txaKost.setText(String.format("De kost bedraagt € %.2f", kost.jaarlijkseKost()));
		
		
	}

	// Deze methode wordt gebruikt om de titels van de beheerskosten op te halen (om
	// in de Combobox te zetten)
	private List<String> geefAlleTitels(List<BeheerskostDTO> dtos) {
		List<String> titels = new ArrayList<>();
		for (BeheerskostDTO dto : dc.geefAlleBeheerskosten()) {
			String titel = switch (dto.soort()) {
			case 'Z' -> "Zichtrekening";
			case 'S' -> "Spaarrekening";
			default -> "Kluis";
			};
			titels.add(String.format("%s van %s", titel, dto.houder()));
		}
		return titels;
	}

	// Deze methode wordt gebruikt om de details van een Beheerskost te bepalen
	private String geefDetails(BeheerskostDTO dto) {
		return switch (dto.soort()) {
		case 'S' -> String.format(
				"De spaarrekening met rekeningnummer %s van %s bevat %.2f Euro.%nDe aangroeiintrest bedraagt %.2f%%",
				geefRekeningnummer(dto), dto.houder(), dto.saldo(), dc.geefAangroeiIntrestSpaarRekening());
		case 'Z' -> String.format(
				"De zichtrekening met rekeningnummer %s van %s bevat %.2f Euro.%nOp deze rekening kan tot %.2f Euro onder nul gegaan worden.",
				geefRekeningnummer(dto), dto.houder(), dto.saldo(), Math.abs(dto.maxKredietOnderNul()));
		default -> String.format("De kluis van %s heeft kluisnummer %d", dto.houder(), dto.kluisnr());
		};
	}

	private String geefRekeningnummer(BeheerskostDTO dto) {
		long reknr = dto.rekeningnr();
		long eerste = reknr / 1000000000;
		long middenste = reknr % 1000000000;
		long laatste = middenste % 100;
		middenste = middenste / 100;
		return String.format("%03d-%07d-%02d", eerste, middenste, laatste);
	}
}