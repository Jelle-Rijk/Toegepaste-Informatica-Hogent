module h05_Oef06_Containers_Starter {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	requires javafx.fxml;

	exports main to javafx.graphics;

	opens gui to javafx.fxml;
}