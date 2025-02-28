package domein;

import java.util.ArrayList;
import java.util.List;

public class DomeinController {

	private final BestellingRepository bestellingRepo;

	public DomeinController() {
		bestellingRepo = new BestellingRepository();
	}

	public void voegBestellingToe(int printers, int laptops, int scanners) {
		bestellingRepo.voegToe(new Bestelling(printers, laptops, scanners));
	}

	public List<String> geefBestellingen() {
		List<Bestelling> bestellingen = bestellingRepo.getBestellingen();
		List<String> overzicht = new ArrayList<>();
		for (Bestelling b : bestellingen)
			overzicht.add(b.toString());
		return overzicht;
	}
}
