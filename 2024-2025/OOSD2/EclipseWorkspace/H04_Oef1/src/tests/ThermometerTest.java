package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Thermometer;

class ThermometerTest {
	private Thermometer t;
	private static final int DEFAULT_TEMP = 32;
	private static final int DEFAULT_TEMP_CELSIUS = 0;

	@BeforeEach
	void maakThermometer() {
		t = new Thermometer();
	}
	// CONSTRUCTOR

	@Test
	void maakThermometer_ValidThermometer_StandaardTempSet() {
		assertEquals(DEFAULT_TEMP, t.getAantalGraden());
	}
	
//	SETTER
	@Test
	void setAantalGraden() {
		t.setAantalGraden(52);
		assertEquals(52, t.getAantalGraden());
	}
	
//	CONVERTEER NAAR CELSIUS
	@Test
	void converteerNaarCelsius_DefaultTemp_Returnt0() {
		assertEquals(DEFAULT_TEMP_CELSIUS, t.converteerNaarCelsius());
	}
	@Test
	void converteerNaarCelsius_100F_Returnt37() {
		t.setAantalGraden(100);
		assertEquals(37, t.converteerNaarCelsius());
	}

}
