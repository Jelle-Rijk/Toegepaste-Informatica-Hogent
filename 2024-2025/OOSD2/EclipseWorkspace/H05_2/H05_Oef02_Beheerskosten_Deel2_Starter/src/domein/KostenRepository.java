package domein;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import persistentie.BeheerskostenMapper;

public class KostenRepository {
	private List<Beheerskost> kosten;
	private BeheerskostenMapper bm;

	public KostenRepository() {
		bm = new BeheerskostenMapper();
		kosten = bm.geefBeheerskosten();
	}

	public List<Beheerskost> getKosten() {
		return kosten;
	}

	public Beheerskost geefBeheerskost(int index) {
		return kosten.get(index);
	}

	public List<Rekening> geefRekeningen() {
		return kosten.stream().filter(kost -> kost instanceof Rekening).map(kost -> (Rekening) kost)
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public Rekening geefRekening(int index) {
		return geefRekeningen().get(index);
	}
}
