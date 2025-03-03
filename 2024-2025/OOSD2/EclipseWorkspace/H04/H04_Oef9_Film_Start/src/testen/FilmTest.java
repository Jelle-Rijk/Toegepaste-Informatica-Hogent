package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Film;
import exceptions.LegeStringException;

class FilmTest {

	@Test
	void maakFilm_alleParametersOk_creatieObject() throws LegeStringException {
		
		String naam = "test";
		int jaar = 2005;
		int sterren = 4;
		
		Film f = new Film(naam,sterren,jaar);
		
		Assertions.assertEquals(naam, f.getNaam());
		Assertions.assertEquals(sterren, f.getSterren());
		Assertions.assertEquals(jaar, f.getJaar());
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {" ","         ","\t\t","\n"})
	void maakFilm_legeNaam_exception(String naam) {
		
		Assertions.assertThrows(LegeStringException.class, () -> new Film(naam,3,2018));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {-5,-1,6,10})
	void maakFilm_aantalSterrenTeKleinOfTeGroot_exception(int sterren) {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Film("test",sterren,2018));
	}	
	
	@ParameterizedTest
	@ValueSource(ints = {Film.MIN_STERREN, Film.MAX_STERREN})
	void maakFilm_aantalSterrenGrenswaarde_maaktObject(int sterren) {
		
		Assertions.assertDoesNotThrow(() -> new Film("test",sterren,2018));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {Film.MIN_JAAR-1, Film.MIN_JAAR-10, Film.HUIDIG_JAAR+1, Film.HUIDIG_JAAR+10})
	void maakFilm_jaarTeKleinOfTeGroot_exception(int jaar) {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Film("test",3,jaar));
	}	
	
	@ParameterizedTest
	@ValueSource(ints = {Film.MIN_JAAR, 2022})
	void maakFilm_jaarGrenswaarde_maaktObject(int jaar) {
		
		Assertions.assertDoesNotThrow(() -> new Film("test",3,jaar));
	}
	
	
	@Test
	void equals_naamEnJaarGelijk_gelijkeObjecten() throws LegeStringException {
		
		Film f1 = new Film("naam", 3, 2018);
		Film f2 = new Film("naam", 1, 2018);
		
		Assertions.assertTrue(f1.equals(f2));
	}
	
	@Test
	void equals_naamEnSterrenGelijk_verschillendeObjecten() throws LegeStringException {
		
		Film f1 = new Film("naam", 1, 2018);
		Film f2 = new Film("naam", 1, 2016);
		
		Assertions.assertFalse(f1.equals(f2));
	}
	
	@Test
	void equals_jaarEnSterrenGelijk_verschillendeObjecten() throws LegeStringException {
		
		Film f1 = new Film("naam1", 1, 2018);
		Film f2 = new Film("naam2", 1, 2018);
		
		Assertions.assertFalse(f1.equals(f2));
	}
}
