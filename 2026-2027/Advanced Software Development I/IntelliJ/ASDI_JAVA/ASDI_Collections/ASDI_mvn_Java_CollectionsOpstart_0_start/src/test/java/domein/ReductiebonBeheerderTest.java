package domein;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReductiebonBeheerderTest {

	private ReductiebonBeheerder reductiebonBeheerder;

	@BeforeEach
	void setUp() {
		reductiebonBeheerder = new ReductiebonBeheerder();
	}

	@Test
	void testVraag1() {
		List<String> reductiebonCodes = reductiebonBeheerder.geefReductiebonCodes(20);
		assertEquals(3, reductiebonCodes.size());
		String[] verwachteResultaat = { "R11", "R12", "R13" };
		for (int i = 0; i < verwachteResultaat.length; i++)
			assertEquals(verwachteResultaat[i], reductiebonCodes.get(i));

	}

	@Test
	void testVraag2() {
		reductiebonBeheerder.sorteerReductiebonnen();
		List<Reductiebon> reductiebonnen = reductiebonBeheerder.getReductiebonLijst();
		assertEquals(6, reductiebonnen.size());
		String[] verwachteResultaat = { "R14", "R15", "R10", "R13", "R11", "R12" };
		for (int i = 0; i < verwachteResultaat.length; i++)
			assertEquals(verwachteResultaat[i], reductiebonnen.get(i).getReductiebonCode());
	}

	@Test
	void testVraag3() {
		double gem = reductiebonBeheerder.geefGemPercVanBonnenInToekomst();
		assertEquals(35, gem, 0.0);
	}

	@Test
	void testVraag4() {
		List<LocalDate> lijstDatums = reductiebonBeheerder.geefUniekeEinddatums();
		assertEquals(4, lijstDatums.size());
		LocalDate[] verwachteResultaat = { LocalDate.of(2026, 5, 15), LocalDate.of(2026, 6, 1),
				LocalDate.of(2026, 9, 20), LocalDate.of(2026, 10, 26) };
		for (int i = 0; i < verwachteResultaat.length; i++)
			assertEquals(verwachteResultaat[i], lijstDatums.get(i));
	}
}
