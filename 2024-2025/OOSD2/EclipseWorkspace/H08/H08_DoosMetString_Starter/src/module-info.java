module oef02 {
	requires transitive javafx.controls;
	requires org.junit.jupiter.api;
	requires org.junit.jupiter.params;
	requires javafx.graphics;

	exports main to javafx.graphics;
}