package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.DoosMetString;

class DoosMetStringTest {

	@ParameterizedTest
	@NullAndEmptySource
	public void maakMijnString_inhoudNull_werptException(String inhoud) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new DoosMetString(inhoud);
		});
	}

	@Test
	public void maakMijnString_inhoudIngevuld_maaktMijnStringMetOpgegevenInhoud() {
		DoosMetString dms = new DoosMetString("test");
		Assertions.assertEquals("test", dms.getInhoud());
	}

	@ParameterizedTest
	@ValueSource(strings = { "a", "xax", "xxax" })
	public void geefMiddelsteKar_retourneertMiddelsteKarakter(String inhoud) {
		DoosMetString dms = new DoosMetString(inhoud);
		Assertions.assertEquals('a', dms.geefMiddelsteKarakterVanInhoud());
	}

	@ParameterizedTest
	@ValueSource(strings = { "raar", "lepel", "a" })
	public void bevatPalindroom_inhoudIsPalindroom_retourneertTrue(String inhoud) {
		DoosMetString dms = new DoosMetString(inhoud);
		Assertions.assertTrue(dms.bevatPalindroom());
	}

	@ParameterizedTest
	@ValueSource(strings = { "ab", "aabcaa" })
	public void bevatPalindroom_inhoudIsGeenPalindroom_retourneertFalse(String inhoud) {
		DoosMetString dms = new DoosMetString(inhoud);
		Assertions.assertFalse(dms.bevatPalindroom());
	}

	@Test
	public void geefOmgekeerdeInhoud_retourneertOmgekeerdeInhoud() {
		DoosMetString dms = new DoosMetString("abcde");
		Assertions.assertEquals("edcba", dms.geefOmgekeerdeInhoud());
	}

}
