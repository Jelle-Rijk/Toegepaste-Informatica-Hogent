package com.example.asdi_mvn_dp_oef6_opgave.gui;

import domein.DomeinController;
import static utils.Soort.*;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

public class BedrijfStageFrameController extends HBox {

    private final DomeinController domeinController;

    private final FormPanelController formPanel;
    private final DetailPanelController detailPanel;

    public BedrijfStageFrameController(DomeinController facade) {

        this.domeinController = facade;

        formPanel = new FormPanelController(domeinController);
        detailPanel = new DetailPanelController(domeinController);
        
        //TODO STAGE
        //TODO BEDRIJF
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BedrijfStageFrame.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        getChildren().addAll(formPanel, detailPanel);
    }

}
