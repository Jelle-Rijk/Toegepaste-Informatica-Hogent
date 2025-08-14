module memo {
	requires javafx.controls;

	// main is de naam van de package die de main-methode bevat
	opens main to javafx.graphics;
}