package domein;

import java.util.ArrayList;
import java.util.List;

public class BestellingRepository {
	List<Bestelling> bestellingen;

	public BestellingRepository() {
		bestellingen = new ArrayList<>();
	}

//	GETTERS - SETTERS
	public List<Bestelling> getBestellingen() {
		return bestellingen;
	}

//	PUBLIC METHODS
	public void voegToe(Bestelling bestelling) {
		bestellingen.add(bestelling);
	}
}
