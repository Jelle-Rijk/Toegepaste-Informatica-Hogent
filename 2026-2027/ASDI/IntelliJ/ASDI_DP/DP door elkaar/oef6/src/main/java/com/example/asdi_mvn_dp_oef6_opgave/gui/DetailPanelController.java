package com.example.asdi_mvn_dp_oef6_opgave.gui;

import domein.DomeinController;
import utils.Soort;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class DetailPanelController extends AnchorPane {

    @FXML
    private TextField txtStageId;

    @FXML
    private TextField txtBedrijfId;

    private final DomeinController domeinController;

    public DetailPanelController(DomeinController domeinController) {

        this.domeinController = domeinController;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailPanel.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    //Voor JUnit
    protected String getStageId() {
        return txtStageId.getText();
    }

    protected String getBedrijfId() {
        return txtBedrijfId.getText();
    }
}
