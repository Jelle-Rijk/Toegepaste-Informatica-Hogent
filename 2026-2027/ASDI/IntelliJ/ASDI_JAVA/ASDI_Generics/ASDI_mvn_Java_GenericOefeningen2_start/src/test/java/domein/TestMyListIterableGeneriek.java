package domein;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMyListIterableGeneriek {

	private MyListIterable<String> woordenLijst;

	@BeforeEach
	void setUp() {
		woordenLijst = new MyListIterable<>("woordenlijst");
	}

	@Test
	void toonLijst() {
		woordenLijst.insertAtFront("lekker");
		woordenLijst.insertAtFront("zijn");
		woordenLijst.insertAtFront("wafels");
		String zin = woordenLijst.toString().replaceAll("\\s+", " ").trim();
		assertEquals("The woordenlijst is: wafels zijn lekker", zin);
	}

	@Test
	void toonLegeLijst() {
		String zin = woordenLijst.toString().replaceAll("\\s+", " ").trim();
		assertEquals("woordenlijst is empty", zin);
	}

}
