package domein;

public class ConcertRegistratie implements Vertoonbaar {
	private final String artiest;
	private final String concertNaam;

//	CONSTRUCTORS
	public ConcertRegistratie(String artiest, String concertNaam) {
		controleerIngevuld(artiest);
		controleerIngevuld(concertNaam);
		this.artiest = artiest;
		this.concertNaam = concertNaam;
	}

//	GETTERS - SETTERS
	public String getArtiest() {
		return artiest;
	}

	public String getConcertNaam() {
		return concertNaam;
	}

//	PUBLIC METHODS
	@Override
	public int wordtVertoondInZaal() {
		return 2;
	}
	
//	PRIVATE METHODS
	private void controleerIngevuld(String tekst) {
		if(tekst == null || tekst.isBlank())
			throw new IllegalArgumentException("Tekst is niet ingevuld.");
	}

}
