package tests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Bestelling;
import exceptions.BestellingException;

class BestellingTest {
	private final static int MIN_TOTAL = 1;
	private final static int MAX_TOTAL = 8;
	private final static int MAX_PRINTERS = 4;
	private final static int MAX_SCANNERS = 3;
	private final static int MAX_LAPTOPS = 2;
	private Bestelling b;
	
	@BeforeEach
	void maakBestelling() throws BestellingException {
		b = new Bestelling(1,1,1);
	}

//	CONSTRUCTOR
	@Test
	void maakBestelling_ValidParamaters_maaktBestelling() {
		assertTrue(b instanceof Bestelling);
	}
	
	@Test
	void maakBestelling_TeWeinigArtikelen_WerptException() {
		assertThrows(BestellingException.class, () -> new Bestelling(0,0,0));
	}
	@Test
	void maakBestelling_TeVeelArtikelen_WerptException() {
		assertThrows(BestellingException.class, () -> new Bestelling(MAX_PRINTERS,MAX_SCANNERS,MAX_LAPTOPS));
	}

	
	@ParameterizedTest
	@ValueSource(ints = {-6, -1, MAX_PRINTERS + 1})
	void maakBestelling_OngeldigPrinters_WerptException(int printers) {
		assertThrows(IllegalArgumentException.class, () -> new Bestelling(printers, 0, 0));
	}
	@ParameterizedTest
	@ValueSource(ints = {-6, -1, MAX_SCANNERS + 1})
	void maakBestelling_OngeldigScanners_WerptException(int scanners) {
		assertThrows(IllegalArgumentException.class, () -> new Bestelling(0, scanners, 0));
	}
	@ParameterizedTest
	@ValueSource(ints = {-6, -1, MAX_LAPTOPS + 1})
	void maakBestelling_OngeldigLaptops_WerptException(int laptops) {
		assertThrows(IllegalArgumentException.class, () -> new Bestelling(0, 0, laptops));
	}

}
