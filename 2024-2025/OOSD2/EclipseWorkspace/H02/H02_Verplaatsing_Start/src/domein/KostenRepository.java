package domein;

import java.util.List;

import persistentie.KostenMapper;

public class KostenRepository {
	private KostenMapper km;
	List<Kost> kosten;

//	CONSTRUCTOR
	public KostenRepository() {
		this.km = new KostenMapper();
		this.kosten = km.geefKosten();
	}

//	GETTERS - SETTERS
	public List<Kost> getKosten() {
		return kosten;
	}

//	PUBLIC METHODS
	public int[] geefAantalDocumentenPerSoort() {
		int[] aantalPerSoort = new int[3]; // tickets, auto, bus/tram
		for (Kost k : getKosten()) {
			if (k instanceof Ticket)
				aantalPerSoort[0]++;
			else if (k instanceof VerplaatsingPerAuto)
				aantalPerSoort[1]++;
			else if (k instanceof VerplaatsingPerBusTram)
				aantalPerSoort[2]++;
		}
		return aantalPerSoort;
	}

}
