package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.ConcertRegistratie;

class ConcertRegistratieTest {
	private ConcertRegistratie c;
	private final static String GELDIGE_ARTIEST = "Delta Heavy";
	private final static String GELDIGE_CONCERTNAAM = "Liquicity Set";
	private final static int CONCERTZAAL = 2;
	
	@BeforeEach
	void setup() {
		c = new ConcertRegistratie(GELDIGE_ARTIEST, GELDIGE_CONCERTNAAM);
	}
	
//	CONSTRUCTOR
	@Test
	void maakConcertRegistratie_GeldigeParameters_maaktConcertRegistratieMetParameters() {
		assertEquals(GELDIGE_ARTIEST, c.getArtiest());
		assertEquals(GELDIGE_CONCERTNAAM, c.getConcertNaam());
	}
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {" ", "   ", "\t", "\n"})
	void maakConcertRegistratie_OngeldigeArtiest_WerptExceptie(String artiest) {
		assertThrows(IllegalArgumentException.class, () -> new ConcertRegistratie(artiest, GELDIGE_CONCERTNAAM));
	}
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {" ", "   ", "\t", "\n"})
	void maakConcertRegistratie_OngeldigeConcertNaamWerptExceptie(String concertNaam) {
		assertThrows(IllegalArgumentException.class, () -> new ConcertRegistratie(GELDIGE_ARTIEST, concertNaam));
	}
	
//	WORDT VERTOOND IN ZAAL
	void wordtVertoondInZaal_GeldigObject_geeftConcertZaal() {
		assertEquals(CONCERTZAAL, c.wordtVertoondInZaal());
	}

}
