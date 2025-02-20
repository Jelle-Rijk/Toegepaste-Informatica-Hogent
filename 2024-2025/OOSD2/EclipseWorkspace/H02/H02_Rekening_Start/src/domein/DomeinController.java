package domein;

import java.util.ArrayList;
import java.util.List;

import dtos.BeheerskostDTO;

public class DomeinController {
	private KostenRepository kRepo;
	
//	CONSTRUCTOR
	public DomeinController() {
		this.kRepo = new KostenRepository();
	}
	
// METHODS
	public List<BeheerskostDTO> geefInfoBeheersKosten() {
		List<BeheerskostDTO> beheerskosten = new ArrayList<>();
		for (Beheerskost kost : kRepo.getKosten()) {
			beheerskosten.add(BeheerskostDTO.maakBeheerskostDTO(kost));
		}
		return beheerskosten;
	}
	
	public double geefAangroeiIntrestSpaarRekening() {
		return SpaarRekening.getAangroeiIntrest();
	}

}
