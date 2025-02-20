package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Gebouw;

class GebouwTest 
{
	private Gebouw g;
	private static final String GELDIGE_NAAM = "een gebouw";
	private static final double GELDIGE_HOOGTE = 6.2;
	private static final double MIN_HOOGTE = 3;
	
	@BeforeEach
	void setUp()
	{
		g = new Gebouw(GELDIGE_NAAM, GELDIGE_HOOGTE);
	}
	
	@Test
	void maakGebouw_geldigeNaamEnHoogte_maaktHetGebouw() 
	{
		assertEquals(GELDIGE_NAAM, g.getNaam());
		assertEquals(GELDIGE_HOOGTE, g.getHoogte());
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource (strings = {" ", "  \t\n   \t   "})
	void maakGebouw_ongeldigeNaam_werptException(String fouteNaam)
	{
		assertThrows(IllegalArgumentException.class, () -> new Gebouw(fouteNaam, GELDIGE_HOOGTE));
	}
	
	@ParameterizedTest
	@ValueSource (doubles = {MIN_HOOGTE - 0.0001, MIN_HOOGTE - 100})
	void maakGebouw_ongeldigeHoogte_werptException(double fouteHoogte)
	{
		assertThrows(IllegalArgumentException.class, () -> new Gebouw(GELDIGE_NAAM, fouteHoogte));
	}
	
	@Test
	void isDraagbaar_geldigGebouw_geeftAltijdFalse()
	{
		assertFalse(g.isDraagbaar());
	}
}
