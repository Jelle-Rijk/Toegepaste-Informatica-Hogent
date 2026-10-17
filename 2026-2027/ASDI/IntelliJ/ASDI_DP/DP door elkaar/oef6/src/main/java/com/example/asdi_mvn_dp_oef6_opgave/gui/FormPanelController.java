package com.example.asdi_mvn_dp_oef6_opgave.gui;

import domein.DomeinController;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FormPanelController extends GridPane {

    @FXML
    private Label lblStageId;
    @FXML
    private TextField txtStageId;
    @FXML
    private TextField txtBedrijfId;
    @FXML
    private Label lblBedrijfId;

    private DomeinController domeinController;

    public FormPanelController(DomeinController domeinController) {

        this.domeinController = domeinController;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FormPanel.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @FXML
    private void stageId(ActionEvent event) {
        setStageId(txtStageId.getText());
    }

    @FXML
    private void bedrijfsId(ActionEvent event) {
        setBedrijfId(txtBedrijfId.getText());
    }

    //Voor JUnit
    protected void setStageId(String stageId) {
        domeinController.setStageId(stageId);
    }

    protected void setBedrijfId(String bedrijfId) {
        domeinController.setBedrijfId(bedrijfId);
    }
}
