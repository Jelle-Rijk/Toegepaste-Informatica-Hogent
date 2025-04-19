package domein;

public class DomeinController {
	private DoosMetString doosMetString;

	public void maakDoosMetString(String inhoud) {
		doosMetString = new DoosMetString(inhoud);
	}

	public String geefInhoud() {
		return doosMetString.getInhoud();
	}

	public String geefOmgekeerdeInhoud() {
		return doosMetString.geefOmgekeerdeInhoud();
	}

	public boolean bevatPalindroom() {
		return doosMetString.bevatPalindroom();
	}

	public String geefWartaal(char letter1, char letter2) {
		return doosMetString.geefWartaal(letter1, letter2);
	}

	public String[] geefGesplitsteZin(String splitsWoord) {
		return doosMetString.splitsOp(splitsWoord);
	}

	public String geefLetterRapport() {
		return doosMetString.geefLetterRapport();
	}
}
