package domein;

import java.util.ArrayList;
import java.util.List;

import exceptions.BestellingException;

public class DomeinController {
	private BestellingRepository bestellingRepo;

	public DomeinController() {
		this.bestellingRepo = new BestellingRepository();
	}
	
	public void voegBestellingToe(int printers, int scanners, int laptops) throws BestellingException {
		bestellingRepo.voegToe(new Bestelling(printers, scanners, laptops));
	}
	
	public List<String> geefBestellingen(){
		List<String> bestellingen = new ArrayList<>();
		for(Bestelling b : bestellingRepo.getBestellingen()) {
			bestellingen.add(b.toString());
		}
		return bestellingen;
	}
}
