package domein;

public class DomeinController {
	private Gebruiker gebruiker;

	public void regsitreerGebruiker(String gebruikersnaam, String wachtwoord, String wachtwoordBevestiging) {
		gebruiker = new Gebruiker(gebruikersnaam, wachtwoord, wachtwoordBevestiging);
	}

	public String geefGebruikersnaam() {
		return gebruiker.getGebruikersnaam();
	}

	public String geefWachtwoord() {
		return gebruiker.getWachtwoord();
	}
}
