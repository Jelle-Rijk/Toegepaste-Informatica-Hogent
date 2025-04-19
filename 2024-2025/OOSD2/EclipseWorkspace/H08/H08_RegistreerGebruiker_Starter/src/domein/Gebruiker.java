package domein;

public class Gebruiker {
	private String wachtwoord;
	private String gebruikersnaam;

	public Gebruiker(String gebruikersnaam, String wachtwoord, String wachtwoordBevestiging) {
		setGebruikersnaam(gebruikersnaam);
		valideerWachtwoordenOpGelijkheid(wachtwoord, wachtwoordBevestiging);
		setWachtwoord(wachtwoord);
	}

	/**
	 * Een geldig wachtwoord bestaat uit minstens 6 tekens waarvan er minstens twee
	 * cijfers zijn. In een wachtwoord zijn enkel kleine letters (alfabet) en
	 * cijfers toegelaten.
	 * 
	 * De methode werpt een IllegalArgumentExceptions met een duidelijke boodschap
	 * wanneer het wachtwoord niet geldig is
	 */
	private void setWachtwoord(String wachtwoord) {
		if (wachtwoord == null || wachtwoord.isEmpty())
			throw new IllegalArgumentException("Gelieve een wachtwoord in te voeren.");
		if (wachtwoord.length() < 6)
			throw new IllegalArgumentException("Het wachtwoord moet minstens 6 tekens bevatten");
		int cijfers = 0;
		for (char c : wachtwoord.toCharArray())
			if (Character.isDigit(c))
				cijfers++;
		if (cijfers < 2)
			throw new IllegalArgumentException("Het wachtwoord moet minstens 2 cijfers bevatten.");
		if (!wachtwoord.matches("[0-9a-z]+"))
			throw new IllegalArgumentException("Het wachtwoord mag enkel cijfers en kleine letters bevatten.");
		this.wachtwoord = wachtwoord;
	}

	/**
	 * Een geldige gebruikersnaam bestaat uit 2 woorden gescheiden door een spatie.
	 * 
	 * Het eerste woord moet starten met een hoofdletter (alfabet) en minstens 4
	 * tekens bevatten (letters, underscore, cijfer)
	 * 
	 * Het tweede woord moet minstens 8 tekens (letters, underscore, cijfer)
	 * bevatten en moet eindigen met een cijfer
	 * 
	 * De methode werpt een IllegalArgumentExceptions met een duidelijke boodschap
	 * wanneer de gebruikersnaam niet geldig is
	 */
	private void setGebruikersnaam(String gebruikersnaam) {
		if (gebruikersnaam == null || !gebruikersnaam.matches("\\w+ \\w+"))
			throw new IllegalArgumentException("De gebruikersnaam moet uit exact 2 delen bestaan gescheiden door een spatie.");
		String[] delen = gebruikersnaam.split(" ");
		if (delen[0].length() < 4)
			throw new IllegalArgumentException("Het eerste deel van de gebruikersnaam moet minstens 4 tekens bevatten.");
		if (delen[1].length() < 8)
			throw new IllegalArgumentException("Het tweede deel van de gebruikersnaam moet minstens 8 tekens bevatten.");
		if (!Character.isUpperCase(delen[0].charAt(0)))
				throw new IllegalArgumentException("Het eerste deel van de gebruikersnaam moet starten met een hoofdletter.");
		if (!Character.isDigit(delen[1].charAt(delen[1].length() - 1)))
			throw new IllegalArgumentException("Het tweede deel van de gebruikersnaam moet eindigen met een cijfer.");
		if (!delen[0].matches("\\w+") || !delen[1].matches("\\w+"))
			throw new IllegalArgumentException("Gebruikersnaam mag naast de spatie enkel letters, underscore en cijfers bevatten.");
		this.gebruikersnaam = gebruikersnaam;
	}

	/**
	 * De methode werpt een IllegalArgumentExceptions met een duidelijke boodschap
	 * wanneer wachtwoord en wachtwoordBevestiging niet gelijk zijn
	 */
	private void valideerWachtwoordenOpGelijkheid(String wachtwoord, String wachtwoordBevestiging) {
		if (wachtwoord == null || wachtwoordBevestiging == null || !wachtwoord.equals(wachtwoordBevestiging))
			throw new IllegalArgumentException("Wachtwoord en wachtwoordbevestiging komen niet overeen.");
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}
}
