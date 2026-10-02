package com.example.asdi_mvn_dp_observer_observableinteger_opgave;

import com.example.asdi_mvn_dp_observer_observableinteger_opgave.gui.ObservableIntegerFrameController;
import domein.DomeinController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ObservableIntegerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new ObservableIntegerFrameController(new DomeinController()));

        stage.setScene(scene);
        stage.setTitle("Observable Integer");

        // The stage will not get smaller than its preferred (initial) size.
        stage.setOnShown(e-> {
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        });
        stage.setTitle("ObservableInteger");
        stage.show();
    }
}
