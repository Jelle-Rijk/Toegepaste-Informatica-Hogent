package domein;

import java.util.List;

import persistentie.VertoonbaarMapper;

public class VertoonbaarRepository {
	private VertoonbaarMapper vm;
	private List<Vertoonbaar> voorstellingen;

//	CONSTRUCTORS
	public VertoonbaarRepository() {
		vm = new VertoonbaarMapper();
		voorstellingen = vm.geefAlleVoorstellingen();
	}

//	GETTERS - SETTERS
	public List<Vertoonbaar> getVoorstellingen() {
		return voorstellingen;
	}

//	PUBLIC METHODS
	public void voegVoorstellingToe(Vertoonbaar v) {
		if (!voorstellingen.contains(v))
			voorstellingen.add(v);
	}

	public int geefAantalInZaal(int zaalnr) {
		int totaal = 0;
		for (Vertoonbaar v : voorstellingen)
			if (v.wordtVertoondInZaal() == zaalnr)
				totaal++;
		return totaal;
	}

}
