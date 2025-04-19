package main;

import domein.DomeinController;
import gui.StartScherm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUp extends Application {
	@Override
	public void start(Stage primaryStage) {
		StartScherm grid = new StartScherm(new DomeinController());
		Scene scene = new Scene(grid, 500, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Doos Met String");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}