package domein;

import java.util.List;

import dto.VoorstellingDTO;
public class DomeinController {
	private VertoonbaarRepository vertoonbaarRepo;

	public DomeinController() {
		this.vertoonbaarRepo = new VertoonbaarRepository();
	}

	public void voegVoorstellingToe(String naam, int sterren, int jaar) {
		vertoonbaarRepo.voegVoorstellingToe(new Film(naam, sterren, jaar));
	}

	public void voegVoorstellingToe(String artiest, String concertNaam) {
		vertoonbaarRepo.voegVoorstellingToe(new ConcertRegistratie(artiest, concertNaam));
	}

	public VoorstellingDTO[] geefAlleVoorstellingen() {
		List<Vertoonbaar> voorstellingen = vertoonbaarRepo.getVoorstellingen();
		VoorstellingDTO[] dtos = new VoorstellingDTO[voorstellingen.size()];
		int index = 0;
		for (Vertoonbaar v : vertoonbaarRepo.getVoorstellingen()) {
			dtos[index] = VoorstellingDTO.maakVoorstellingDTO(v);
			index++;
		}
		return dtos;
	}

	public int geefAantalInZaal(int zaalnr) {
		return vertoonbaarRepo.geefAantalInZaal(zaalnr);
	}

}
