package main;

import domein.DomeinController;
import gui.WelkomScherm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StartUp extends Application {

	@Override
	public void start(Stage primaryStage) {
		DomeinController dc = new DomeinController();
		WelkomScherm root = new WelkomScherm(dc);
		Scene scene = new Scene(root, 1000, 600);
		scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
		Font.loadFont(getClass().getResource("/fonts/FFFT_tusj.ttf").toExternalForm(), 10);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Sliding Puzzle");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
