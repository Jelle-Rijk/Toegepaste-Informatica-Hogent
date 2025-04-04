package domein;

import java.util.ArrayList;
import java.util.Collection;

import dto.AutoDTO;
import dto.OnderhoudDTO;

public class DomeinController {
	private final Garage garage;
	private final OnderhoudRepository onderhoudRepository;

	public DomeinController() {
		onderhoudRepository = new OnderhoudRepository();
		garage = new Garage(onderhoudRepository.geefAlleOnderhouden());
	}

	public Collection<AutoDTO> geefAlleAutosInOnderhoud() {
		Collection<AutoDTO> dtos = new ArrayList<>();
		Collection<Auto> autos = garage.geefAlleAutosInOnderhoud();
		for (Auto auto : autos) {
			dtos.add(new AutoDTO(auto));
		}
		return dtos;
	}

	public Collection<OnderhoudDTO> geefAlleOnderhouden() {
		Collection<OnderhoudDTO> dtos = new ArrayList<>();
		Collection<Onderhoud> onderhouden = garage.getOnderhouden();
		for (Onderhoud onderhoud : onderhouden) {
			dtos.add(new OnderhoudDTO(onderhoud));
		}
		return dtos;
	}

	public void sorteerOnderhouden() {
		garage.sorteerOnderhouden();
	}

	public void voegAaneengrenzendeOnderhoudenSamen() {
		garage.voegAaneengrenzendeOnderhoudenSamen();
	}
}
