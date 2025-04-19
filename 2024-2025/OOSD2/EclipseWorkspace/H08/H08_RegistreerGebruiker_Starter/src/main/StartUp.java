package main;

import domein.DomeinController;
import gui.RegistratieScherm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUp extends Application {
	@Override
	public void start(Stage primaryStage) {
		RegistratieScherm grid = new RegistratieScherm(new DomeinController());
		Scene scene = new Scene(grid, 450, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Registratie");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}