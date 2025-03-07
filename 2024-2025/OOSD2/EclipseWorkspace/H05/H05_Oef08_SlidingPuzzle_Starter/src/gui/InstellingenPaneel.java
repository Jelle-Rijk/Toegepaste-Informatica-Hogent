package gui;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import util.Moeilijkheidsgraad;

public class InstellingenPaneel extends VBox {
	private ToggleGroup tglAantalStukken;
	private ToggleGroup tglMoeilijkheidsgraad;

	public InstellingenPaneel() {
		toonKeuzesAantalStukken();
		toonKeuzesMoeilijkheidsgraad();
	}

	private void toonKeuzesMoeilijkheidsgraad() {
		Label lblDifficulty = new Label("Difficulty");
		lblDifficulty.getStyleClass().add("settingsText");
		tglMoeilijkheidsgraad = new ToggleGroup();
		getChildren().add(lblDifficulty);
		for (Moeilijkheidsgraad diff : Moeilijkheidsgraad.values()) {
			RadioButton rbtnDiff = new RadioButton(String.format("%s", diff.name().toLowerCase()));
			rbtnDiff.setToggleGroup(tglMoeilijkheidsgraad);
			rbtnDiff.setSelected(diff.name().equals("EASY"));
			getChildren().add(rbtnDiff);
		}
	}

	private void toonKeuzesAantalStukken() {
		this.getStyleClass().add("vbox");
		this.setSpacing(10);
		Label lblNrOfPieces = new Label("Number of pieces");
		lblNrOfPieces.getStyleClass().add("settingsText");
		tglAantalStukken = new ToggleGroup();
		getChildren().add(lblNrOfPieces);
		for (int i : new int[] { 16, 25 }) {
			RadioButton rbtnPieces = new RadioButton(String.format("%d", i));
			rbtnPieces.setToggleGroup(tglAantalStukken);
			rbtnPieces.setSelected(i == 16);
			getChildren().add(rbtnPieces);
		}
	}

	public int geefAantalStukken() {
		RadioButton selectedRadioButton = (RadioButton) tglAantalStukken.getSelectedToggle();
		return Integer.parseInt(selectedRadioButton.getText());
	}

	public Moeilijkheidsgraad geefMoeilijkheidsgraad() {
		RadioButton selectedRadioButton = (RadioButton) tglMoeilijkheidsgraad.getSelectedToggle();
		return Moeilijkheidsgraad.valueOf(selectedRadioButton.getText().toUpperCase());
	}
}
