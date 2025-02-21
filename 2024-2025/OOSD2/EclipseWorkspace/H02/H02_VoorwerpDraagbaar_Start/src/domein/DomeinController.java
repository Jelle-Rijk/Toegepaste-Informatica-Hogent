package domein;

import java.util.ArrayList;
import java.util.List;

import dto.DraagbaarDTO;

public class DomeinController {
	private DraagbaarRepository draagbaarRepo;

	public DomeinController() {
		this.draagbaarRepo = new DraagbaarRepository();
	}

	public void voegWapenToe(String naam, double gewicht, int niveau, int kracht, boolean gebruikt) {
		draagbaarRepo.voegDraagbaarItemToe(new Wapen(naam, gewicht, niveau, kracht, gebruikt));
	}

	public void voegSleutelToe(String naam, double gewicht, int niveau, int deur) {
		draagbaarRepo.voegDraagbaarItemToe(new Sleutel(naam, gewicht, niveau, deur));
	}

	public void voegGebouwToe(String naam, double hoogte) {
		draagbaarRepo.voegDraagbaarItemToe(new Gebouw(naam, hoogte));
	}

	public int geefAantalSleutelsInOmloop() {
		return Sleutel.getAantalInOmloop();
	}

	public List<DraagbaarDTO> geefDataCollectie() {
		List<DraagbaarDTO> dtos = new ArrayList<>();
		for (Draagbaar d : draagbaarRepo.getCollectie())
		{
			dtos.add(DraagbaarDTO.maakDraagbaarDTO(d));
		}
		return dtos;
	}
}
