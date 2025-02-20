package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Film;

class FilmTest 
{
	private Film f1, f2, f3;
	private String naam = "test";
	private int jaar = 2005, ster1 = 4, ster2 = 3, ster3 = 1;
	
	@BeforeEach
	void setUp()
	{
		f1 = new Film(naam,ster1,jaar);
		f2 = new Film(naam,ster2,jaar);
		f3 = new Film(naam,ster3,jaar);
	}
	
	@Test
	void wordtVertoondInZaal_meerDan3Sterren_zaalNr1()
	{
		assertEquals(1, f1.wordtVertoondInZaal());
	}
	
	@Test
	void wordtVertoondInZaal_precies3Sterren_zaalNr2()
	{
		assertEquals(2, f2.wordtVertoondInZaal());
	}
	
	@Test
	void wordtVertoondInZaal_minderDan3Sterren_zaalNr3()
	{
		assertEquals(3, f3.wordtVertoondInZaal());
	}
}