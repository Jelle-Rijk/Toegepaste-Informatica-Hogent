package utils;

public class Validator {

	/**
	 * Een geldige postcode start met een cijfer verschillend van 0, gevolgd door
	 * exact drie cijfers.
	 * 
	 * @param postcode - de postcode die moet gevalideerd worden
	 * @return true wanneer postcode geldig is, false in andere gevallen
	 */
	public static boolean validatePostcode(String postcode) {
		return postcode != null && postcode.matches("[1-9]\\d{3}");
	}

	/**
	 * Een geldig huisnummer bevat cijfers en eventueel 1 letter (alfabet). Het
	 * huisnummer moet starten met een cijfer verschillend van 0. Indien een letter
	 * aanwezig is mag die letter gevolgd worden door hoogstens 1 cijfer.
	 * 
	 * @param postcode - het huisnummer die moet gevalideerd worden
	 * @return true wanneer huisnummer geldig is, false in andere gevallen
	 */
	public static boolean validateHuisnummer(String huisnummer) {
		return huisnummer != null && huisnummer.matches("[1-9]\\d*(\\w\\d?)?");
	}

	/**
	 * Een geldige naam start met minstens twee letters. De eerste letter moet een
	 * letter uit het alfabet zijn, daaropvolgende letters zijn letters uit het
	 * alfabet of �, �, � of �. In de naam mogen na de eerste twee letters spaties
	 * voorkomen.
	 * 
	 * @param naam - de naam die moet gevalideerd worden
	 * @return true wanneer naam geldig is, false in andere gevallen
	 */
	public static boolean validateNaam(String naam) {
		return naam != null && naam.matches("[A-Za-z][A-Za-z����][A-Za-z���� ]*");
	}

	/**
	 * Een geldig e-mail adres bevat exact ��n @-teken.
	 * 
	 * Voor het @-teken: letters (alfabet) en puntjes; het eerste teken moet een
	 * letter zijn en elke punt moet gevolgd worden door minstens 1 letter
	 * 
	 * Na het @-teken: letters, puntjes of - tekens; het eerste teken moet een
	 * letter zijn en elke puntje of '-' teken moet gevolgd worden door minstens 1
	 * letter
	 * 
	 * @param email - het e-mail adres die moet gevalideerd worden
	 * @return true wanneer email geldig is, false in andere gevallen
	 */
	public static boolean validateEmail(String email) {
		return email != null && email.matches("[A-Za-z]+(\\.[A-Za-z]+)*@[A-Za-z]+([.-][A-Za-z]+)*");

	}
}
