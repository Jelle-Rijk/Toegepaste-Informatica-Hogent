package domein;

import java.util.ArrayList;
import java.util.List;

public class DomeinController {

	private final VertoonbaarRepository vertoonbaarRepo;
	
	public DomeinController() {
		vertoonbaarRepo = new VertoonbaarRepository();
	}

	
	public void voegVoorstellingToe(String[] infoVoorstelling)
	{
		if (infoVoorstelling.length == 3)
		{
			String naam = infoVoorstelling[0];
			int sterren = Integer.parseInt(infoVoorstelling[1]);
			int jaar = Integer.parseInt(infoVoorstelling[2]);
			vertoonbaarRepo.voegVoorstellingToe(new Film(naam, sterren, jaar));
		}
		else
			vertoonbaarRepo.voegVoorstellingToe(new ConcertRegistratie(infoVoorstelling[0], infoVoorstelling[1]));
	}


	public String[] geefAlleVoorstellingen()
	{
		List<Vertoonbaar> lijst = vertoonbaarRepo.getVoorstellingen();
		String[] lijstStrings = new String[lijst.size()];
		
		int i=0;
		for (Vertoonbaar v : lijst)
			lijstStrings[i++] = String.format("%s in zaal %d", v.toString(), v.wordtVertoondInZaal());
		
		return lijstStrings;
	}


	public int geefAantalInZaal(int zaalnr)
	{
		return vertoonbaarRepo.geefAantalInZaal(zaalnr);
	}
}
