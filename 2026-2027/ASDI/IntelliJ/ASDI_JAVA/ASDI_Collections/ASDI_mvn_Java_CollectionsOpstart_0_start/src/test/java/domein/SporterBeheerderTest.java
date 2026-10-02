package domein;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SporterBeheerderTest {

	private SporterBeheerder sporterBeheerder;

	@BeforeEach
	void setUp() {
		sporterBeheerder = new SporterBeheerder();
	}

    @Test
    void testVraag6_sporterBestaat() {
        Reductiebon bon = new Reductiebon("R311", 60, LocalDate.of(2026, 5, 10));
        Sporter sporter = sporterBeheerder.geefEenSporterMetGegevenReductiebon(bon);
        assertEquals(1, sporter.getLidNr());
    }

    @Test
    void testVraag6_sporterBestaatNiet() {
        Reductiebon bon = new Reductiebon("komtNietVoor", 60, LocalDate.of(2026, 5, 10));
        Sporter sporter = sporterBeheerder.geefEenSporterMetGegevenReductiebon(bon);
        assertNull(sporter);
    }

	@Test
	void testVraagExtra1_reductiebonnenMetKorting() {
		List<Reductiebon> bonnen = sporterBeheerder.geefAlleReductiebonnenMetKortingsPercentageX(List.of(10, 40));
		Set<String> resultaat = bonnen.stream().map(Reductiebon::getReductiebonCode).collect(Collectors.toSet());
		Set<String> verwachteResultaat = new HashSet<>(Arrays.asList("R31", "R34", "R36", "R322"));
		assertEquals(verwachteResultaat, resultaat);
	}

	@Test
	void testVraagExtra2_verwijderSporters() {
		assertEquals(6, sporterBeheerder.getSportersLijst().size());
		sporterBeheerder.verwijderAlleSportersMetReductiebonMetPercX(10);
		assertEquals(3, sporterBeheerder.getSportersLijst().size());
	}
}
