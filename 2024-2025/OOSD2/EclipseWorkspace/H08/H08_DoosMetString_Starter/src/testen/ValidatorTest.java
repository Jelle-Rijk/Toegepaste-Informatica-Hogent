package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import utils.Validator;

class ValidatorTest {

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "abcd", "123a", "a123", "12ab", "123", "12345", "0123" })
	public void validatePostcode_OngeldigePostcode_RetourneertFalse(String postcode) {
		Assertions.assertFalse(Validator.validatePostcode(postcode));
	}

	@ParameterizedTest
	@ValueSource(strings = { "9700", "8000", "1234" })
	public void validatePostcode_GeldigePostcode_RetourneertTrue(String postcode) {
		Assertions.assertTrue(Validator.validatePostcode(postcode));
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "0", "01A", "10A20", "12AB1", "12AB" })
	public void validateHuisnummer_OngeldigHuisnummer_RetourneertFalse(String huisnummer) {
		Assertions.assertFalse(Validator.validateHuisnummer(huisnummer));
	}

	@ParameterizedTest
	@ValueSource(strings = { "1", "10", "1A", "10A", "10A2" })
	public void validateHuisnummer_GeldigeHuisnummer_RetourneertTrue(String huisnummer) {
		Assertions.assertTrue(Validator.validateHuisnummer(huisnummer));
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "1acb", "a1bc", "ab1", "écd" })
	public void validateNaam_OngeldigeNaam_RetourneertFalse(String naam) {
		Assertions.assertFalse(Validator.validateNaam(naam));
	}

	@ParameterizedTest
	@ValueSource(strings = { "Dé ünder", "vervaecke", "Vïn der veldé" })
	public void validateNaam_GeldigeNaam_RetourneertTrue(String naam) {
		Assertions.assertTrue(Validator.validateNaam(naam));
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "student.hogent.be", "1student@hogent.be", "student@hogent.-be", "student@hogent.",
			"student@hogent-", "student@hogent-A.", ".student@hogent.be" })
	public void validateEmail_OngeldigEmail_RetourneertFalse(String email) {
		Assertions.assertFalse(Validator.validateEmail(email));
	}

	@ParameterizedTest
	@ValueSource(strings = { "student@hogent.be", "student.student@hogent-be", "student.student@hogent-com.be",
			"student.student@hogent.com-be" })
	public void validateEmail_GeldigEmail_RetourneertTrue(String email) {
		Assertions.assertTrue(Validator.validateEmail(email));
	}
}
