package gui;

import domein.DomeinController;
import domein.MemoryGame;
import dto.KaartDTO;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class KaartenPaneel extends GridPane {
	public static final String PAD_NAAR_IMAGES = "/images/masks/";
	private DomeinController dc;
	private GeradenKaartenPaneel geradenKaartenPaneel;
	private SpelScherm spelScherm;

	public KaartenPaneel(DomeinController dc, GeradenKaartenPaneel gk, SpelScherm spelScherm) {
		this.geradenKaartenPaneel = gk;
		this.spelScherm = spelScherm;
		this.dc = dc;
		bouwScherm();
	}

	private void bouwScherm() {
		Image imgWelkom = new Image(getClass().getResourceAsStream("/images/welkom.jpg"));
		setBackground(new Background(new BackgroundImage(imgWelkom, null, null, null, null)));
		setAlignment(Pos.CENTER);
		// TODO: Grid definieren met gepaste row- en columnconstraints
		for (int i = 0; i < MemoryGame.AANTAL_RIJEN; i++) {
			RowConstraints row = new RowConstraints();
			row.setPrefHeight(120);
			getRowConstraints().add(row);
		}
		for (int i = 0; i < MemoryGame.AANTAL_KOLOMMEN; i++) {
			ColumnConstraints col = new ColumnConstraints();
			col.setPrefWidth(120);
			getColumnConstraints().add(col);
		}

		toonKaartenOpTafel();
	}

	private void toonKaartenOpTafel() {
		boolean alleOmgedraaideKaartenVerwerkt = dc.zijnAlleOmgedraaideKaartenVerwerkt();
		stelGridPaneIn(alleOmgedraaideKaartenVerwerkt);
		if (dc.isTafelLeeg())
			vraagOmNogEensTeSpelen();
		else
			for (KaartDTO kaart : dc.geefKaartenOpTafel()) {
				String image = kaart.faceUp() ? PAD_NAAR_IMAGES + kaart.image() : "/images/faceDown.jpg";
				ImageView ivCard = new ImageView(new Image(getClass().getResourceAsStream(image)));
				ivCard.setFitWidth(110);
				ivCard.setCursor(Cursor.HAND);
				ivCard.setPreserveRatio(true);
				setHalignment(ivCard, HPos.CENTER);
				setValignment(ivCard, VPos.CENTER);
				add(ivCard, kaart.posX(), kaart.posY());
				stelImageViewIn(ivCard, kaart, alleOmgedraaideKaartenVerwerkt);
			}
	}

	private void stelImageViewIn(ImageView ivCard, KaartDTO kaart, boolean alleOmgedraaideKaartenVerwerkt) {
		ivCard.setOnMouseClicked(evt -> {
			evt.consume();
			if (!alleOmgedraaideKaartenVerwerkt)
				verwerkOmgedraaideKaarten();
			else
				toonKaart(kaart);
		});
	}

	private void stelGridPaneIn(boolean alleOmgedraaideKaartjesVerwerkt) {
		if (alleOmgedraaideKaartjesVerwerkt) {
			setCursor(Cursor.DEFAULT);
			setOnMouseClicked(null);
		} else {
			setCursor(Cursor.HAND);
			setOnMouseClicked(evt -> {
				evt.consume();
				verwerkOmgedraaideKaarten();
			});
		}
	}

	private void toonKaart(KaartDTO kaartDTO) {
		dc.draaiKaart(kaartDTO);
		this.getChildren().clear();
		toonKaartenOpTafel();
	}

	private void verwerkOmgedraaideKaarten() {
		dc.verwerkOmgedraaideKaarten();
		this.getChildren().clear();
		toonKaartenOpTafel();
		geradenKaartenPaneel.toonGeradenKaarten();
	}

	private void vraagOmNogEensTeSpelen() {
		getChildren().clear();
		Button btnPlayAgain = new Button("PLAY AGAIN");
		btnPlayAgain.setAlignment(Pos.CENTER);
		btnPlayAgain.getStyleClass().addAll("styledText", "smallText");
		btnPlayAgain.setOnAction(e -> spelScherm.startSpel());
		add(btnPlayAgain, 1, 1, 2, 2);

		Button btnExit = new Button("EXIT");
		btnExit.setAlignment(Pos.CENTER);
		btnExit.getStyleClass().addAll("styledText", "smallText");
		btnExit.setOnAction(e->Platform.exit());
		add(btnExit, 3, 1, 2, 2);

	}
}
