package com.example.asdi_mvn_dp_oef6_opgave;

import com.example.asdi_mvn_dp_oef6_opgave.gui.BedrijfStageFrameController;
import domein.DomeinController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.IOException;

public class BedrijfStageApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DomeinController domeinController = new DomeinController();
        Scene scene = new Scene(new BedrijfStageFrameController(domeinController), 600, 400);
        scene.getStylesheets().add(
                getClass().getResource("/com/example/asdi_mvn_dp_oef6_opgave/gui/styles.css").toExternalForm()
        );
        stage.setScene(scene);

        // The stage will not get smaller than its preferred (initial) size.
        stage.setOnShown((WindowEvent t) -> {
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        });

        stage.show();
    }
}
