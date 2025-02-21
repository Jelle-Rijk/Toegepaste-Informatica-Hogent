package domein;

import java.util.ArrayList;
import java.util.List;

import dto.KostDTO;

public class DomeinController {
	private KostenRepository kr;

	public DomeinController() {
		this.kr = new KostenRepository();
	}

	public String geefOverzichtAantalDocumenten() {
		int[] aantallen = kr.geefAantalDocumentenPerSoort();
		return String.format("%d ticket%s, %d verplaatsing%s per auto en %d verplaatsing%s per bus/tram.", aantallen[0],
				aantallen[0] == 1 ? "" : "s", aantallen[1], aantallen[1] == 1 ? "" : "en", aantallen[2],
				aantallen[2] == 1 ? "" : "en");
	}

	public List<KostDTO> geefKostenLijst() {
		List<KostDTO> kosten = new ArrayList<>();
		for (Kost k : kr.getKosten())
			kosten.add(KostDTO.maakKostDTO(k));
		return kosten;
	}

	public double berekenTotaalKosten() {
		double totaal = 0;
		for (Kost k : kr.getKosten())
			totaal += k instanceof Verplaatsing? k.berekenPrijsZonderBtw(): k.berekenPrijs();
		return totaal;
	}

}
