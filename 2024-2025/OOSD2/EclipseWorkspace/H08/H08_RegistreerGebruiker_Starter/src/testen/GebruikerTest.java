package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Gebruiker;

public class GebruikerTest {
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "1studente java1", "studentejava1", "studente_3java1", "student java2",
			"studente javacursus", "java3\tStudente_1", "java3 Studente_1", "java3 Studente_1", "java3 Studente_1",
			"Java3 St!udente_1", "Ja!va3 Studente_1" })
	public void maakGebruiker_GebruikersnaamOngeldig_werptException(String gebruikersnaam) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Gebruiker(gebruikersnaam, "123456ab", "123456ab");
		});
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "12345", "abcdef", "abc0def", "ABC12DEF", "abc12Def" })
	public void maakGebruiker_WachtwoordOngeldig_werptException(String wachtwoord) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Gebruiker("Java Studente01", wachtwoord, wachtwoord);
		});
	}

	@Test
	public void maakGebruiker_WachtwoordenKomenNietOvereen_WerptException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Gebruiker("Java Studente01", "123ab456", "123ba456");
		});
	}

	@ParameterizedTest
	@ValueSource(strings = { "Java3 Studente_1", "Java Studente1", "Jav0 Studente1_N1", "StudentenHo_Gent Java_Fun23" })
	public void maakGebruiker_GebruikersnaamEnWachtwoordGeldig_SteltGebruikersnaamIn(String gebruikersnaam) {
		Gebruiker gebruiker = new Gebruiker(gebruikersnaam, "123456ab", "123456ab");
		assertEquals(gebruikersnaam, gebruiker.getGebruikersnaam());
	}

	@ParameterizedTest
	@ValueSource(strings = { "123456", "abc12d", "abc12de", "123ab4", "123abc456", "abc456" })
	public void maakGebruiker_GebruikersnaamEnWachtwoordGeldig_SteltWachtwoordIn(String wachtwoord) {
		Gebruiker gebruiker = new Gebruiker("Java Studente01", wachtwoord, wachtwoord);
		assertEquals(wachtwoord, gebruiker.getWachtwoord());
	}
}
