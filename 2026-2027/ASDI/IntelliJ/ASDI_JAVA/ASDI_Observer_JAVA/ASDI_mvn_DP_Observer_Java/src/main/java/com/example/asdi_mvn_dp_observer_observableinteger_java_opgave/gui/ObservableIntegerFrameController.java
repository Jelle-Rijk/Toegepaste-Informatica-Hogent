package com.example.asdi_mvn_dp_observer_observableinteger_java_opgave.gui;

import domein.DomeinController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ObservableIntegerFrameController extends VBox implements PropertyChangeListener {

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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ObservableIntegerFrame.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        domeinController.addObserver(this);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equalsIgnoreCase("integer")) {
            updateLabels((int) evt.getNewValue());
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

    private void updateLabels(int value) {
        lblValue.setText("Value: %d".formatted(value));
        lblDoubleValue.setText("Double value: %d".formatted(domeinController.getDoubleValue()));
    }


    //Voor JUnit
    protected String getValue() {
        return lblValue.getText();
    }

}
