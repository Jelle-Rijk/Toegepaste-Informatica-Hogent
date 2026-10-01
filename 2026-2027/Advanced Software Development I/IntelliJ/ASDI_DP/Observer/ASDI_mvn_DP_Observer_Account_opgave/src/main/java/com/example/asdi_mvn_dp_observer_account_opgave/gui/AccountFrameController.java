package com.example.asdi_mvn_dp_observer_account_opgave.gui;

import java.io.IOException;

import domain.Account;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class AccountFrameController extends GridPane {

    private final Account domainController;
    private final AccountControllerPanelController accountControllerPanel;
    private final AccountTextViewPanelController accountTextViewPanel;
    private final AccountBarGraphViewPanelController accountBarGraphViewPanel;

    public AccountFrameController(Account controller) {
        this.domainController = controller;
        accountControllerPanel = new AccountControllerPanelController(domainController);
        accountTextViewPanel = new AccountTextViewPanelController();
        accountBarGraphViewPanel = new AccountBarGraphViewPanelController();

        controller.addObserver(accountTextViewPanel);
        controller.addObserver(accountBarGraphViewPanel);


        FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountFrame.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        this.add(accountControllerPanel, 0, 0);
        this.add(accountTextViewPanel, 0, 1);
        this.add(accountBarGraphViewPanel, 0, 2);

    }
}
