package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Bestelling;
//import exceptions.BestellingException;

public class BestellingTest {

	@Test
	public void maakBestelling_GeldigeGegevens_MaaktBestelling() /*throws BestellingException*/ {
		Bestelling b = new Bestelling(3, 2, 1);
		assertEquals(3, b.getPrinters());
		assertEquals(2, b.getLaptops());
		assertEquals(1, b.getScanners());
	}

	@Test
	public void maakBestelling_TotaalAantalArtikelenTeGroot_WerptException() {
//		Assertions.assertThrows(BestellingException.class,
//				() -> new Bestelling(Bestelling.MAX_PRINTERS, Bestelling.MAX_SCANNERS, Bestelling.MAX_LAPTOPS));
	}

	@Test
	public void maakBestelling_TotaalAantalArtikelenMaximaalToegestaan_MaaktBestelling() /*throws BestellingException*/ {
		Bestelling b = new Bestelling(4, 2, 2);
		assertEquals(4, b.getPrinters());
		assertEquals(2, b.getLaptops());
		assertEquals(2, b.getScanners());
	}

	@Test
	public void maakBestelling_TotaalAantalArtikelenIsNul_WerptException() {
//		Assertions.assertThrows(BestellingException.class, () -> new Bestelling(0, 0, 0));
	}

	@Test
	public void maakBestelling_TotaalAantalArtikelenIsNetNietNul_MaaktBestelling() /*throws BestellingException*/ {
		Bestelling b = new Bestelling(1, 0, 0);
		assertEquals(1, b.getPrinters());
		assertEquals(0, b.getLaptops());
		assertEquals(0, b.getScanners());
	}

	@ParameterizedTest
	@ValueSource(ints = { Bestelling.MAX_PRINTERS + 1, -1 })
	public void maakBestelling_AantalPrintersNietGeldig_WerptException(int aantalPrinters) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Bestelling(aantalPrinters, 1, 1));
	}

	@ParameterizedTest
	@ValueSource(ints = { Bestelling.MAX_LAPTOPS + 1, -1 })
	public void maakBestelling_AantalLaptopsNietGeldig_WerptException(int aantalLaptops) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Bestelling(1, aantalLaptops, 1));
	}

	@ParameterizedTest
	@ValueSource(ints = { Bestelling.MAX_SCANNERS + 1, -1 })
	public void maakBestelling_AantalScannersNietGeldig_WerptException(int aantalScanners) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Bestelling(1, 1, aantalScanners));
	}
}
