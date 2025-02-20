package domein;

import java.util.List;

import persistentie.BeheerskostenMapper;

public class KostenRepository {
	private BeheerskostenMapper bm;

//	CONSTRUCTOR
	public KostenRepository() {
		this.bm = new BeheerskostenMapper();
	}

//	PUBLIC METHODS
	public List<Beheerskost> getKosten() {
		return bm.geefBeheerskosten();
	}

	public Beheerskost geefBeheerskost(int index) {
		return getKosten().get(index);
	}
}
