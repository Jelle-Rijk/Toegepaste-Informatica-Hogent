package domein;

import exceptions.LegeStringException;

public class ConcertRegistratie implements Vertoonbaar
{
	private final String artiest;
	private final String concertNaam;
	
	public ConcertRegistratie (String artiest, String concertNaam) throws LegeStringException
	{
		controleerIngevuld(artiest);
		controleerIngevuld(concertNaam);
		this.artiest = artiest;
		this.concertNaam = concertNaam;
	}

	private void controleerIngevuld(String tekst) throws LegeStringException
	{
		if (tekst == null || tekst.isBlank())
			throw new LegeStringException("Alle gegevens moeten ingevuld zijn!");
	}
	
	public String getArtiest()
	{
		return artiest;
	}

	public String getConcertNaam()
	{
		return concertNaam;
	}

	@Override
	public String toString()
	{
		return String.format("%s %s van %s", this.getClass().getSimpleName(), concertNaam, artiest);
	}

	@Override
	public int wordtVertoondInZaal()
	{
		return 2;
	}
}
