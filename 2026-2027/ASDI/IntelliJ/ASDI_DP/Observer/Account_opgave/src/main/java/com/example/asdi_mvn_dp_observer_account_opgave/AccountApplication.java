package com.example.asdi_mvn_dp_observer_account_opgave;

import com.example.asdi_mvn_dp_observer_account_opgave.gui.AccountFrameController;
import domain.Account;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AccountApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Account domainController = new Account("Account 1", 1000.00);
        Scene scene = new Scene(new AccountFrameController(domainController));

        // The stage will not get smaller than its preferred (initial) size.
        stage.setOnShown(e-> {
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        });
        stage.setTitle("Account");
        stage.setScene(scene);

        stage.show();
    }

}
