package com.example.asdi_mvn_dp_observer_observableinteger_opgave.gui;

import domein.DomeinController;

import java.io.IOException;

import domein.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ObservableIntegerFrameController extends VBox implements Observer {

    @FXML
    private Label lblValue;

    @FXML
    private Label lblDoubleValue;

    @FXML
    private Button btnUp;

    @FXML
    private Button btnDown;

    private DomeinController domeinController;

    public ObservableIntegerFrameController(DomeinController domeinController) {
        this.domeinController = domeinController;
        domeinController.addIntegerObserver(this);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ObservableIntegerFrame.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    @FXML
    private void up(ActionEvent event) {
        domeinController.up();
    }

    @FXML
    private void down(ActionEvent event) {
        domeinController.down();
    }

    //Voor JUnit
    protected String getValue() {
        return lblValue.getText();
    }

    @Override
    public void update(int value) {
        lblValue.setText("Value: %d".formatted(value));
        lblDoubleValue.setText("Double value: %d".formatted(domeinController.getDoubleValue()));
    }
}
