package gui;

import domein.DomeinController;
import dto.KaartDTO;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class GeradenKaartenPaneel extends HBox {

	private DomeinController dc;

	public void voegKaartjeToe(ImageView ivKaartje) {
		this.getChildren().add(ivKaartje);
	}

	public GeradenKaartenPaneel(DomeinController dc) {
		this.dc = dc;
		setPrefHeight(73);
		setSpacing(10);
		setId("geradenKaartjes");
		setPadding(new Insets(10));
		toonGeradenKaarten();
	}

	public void toonGeradenKaarten() {
		getChildren().clear();
		for (KaartDTO dto : dc.geefGeradenKaarten()) {
			ImageView ivKaartje = new ImageView();
			String imgPath = KaartenPaneel.PAD_NAAR_IMAGES + dto.image();
			Image imgKaartje = new Image(getClass().getResourceAsStream(imgPath));
			ivKaartje.setImage(imgKaartje);
			ivKaartje.setFitWidth(50);
			ivKaartje.setFitHeight(50);
			voegKaartjeToe(ivKaartje);
		}
	}
}
