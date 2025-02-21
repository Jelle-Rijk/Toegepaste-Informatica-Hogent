package dto;

import domein.ConcertRegistratie;
import domein.Film;
import domein.Vertoonbaar;

public record VoorstellingDTO(char soort, String naam, int sterren, int jaar, String concertNaam, String artiest,
		int zaal) {

	public static VoorstellingDTO maakVoorstellingDTO(Vertoonbaar v) {
		if (v instanceof Film f) {
			return new VoorstellingDTO('F', f.getNaam(), f.getSterren(), f.getJaar(), null,
					null, f.wordtVertoondInZaal());
		}
		if (v instanceof ConcertRegistratie c) {
			return new VoorstellingDTO('C', null, 0, 0, c.getConcertNaam(), c.getArtiest(),
					c.wordtVertoondInZaal());
		}
		throw new IllegalArgumentException("Ongeldig Vertoonbaarobject");
	}
}
