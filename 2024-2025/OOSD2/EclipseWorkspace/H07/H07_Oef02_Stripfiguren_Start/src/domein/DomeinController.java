package domein;

import java.util.ArrayList;
import java.util.Collection;

import dto.StripfiguurDTO;

public class DomeinController {
	private final StripfiguurRepository stripfiguurRepo;

	public DomeinController() {
		this.stripfiguurRepo = new StripfiguurRepository();
	}

	public Collection<StripfiguurDTO> geefStripfiguren(Collection<Stripfiguur> stripfiguren) {
		Collection<StripfiguurDTO> resultaat = new ArrayList<>();
		for (Stripfiguur stripfiguur : stripfiguren) {
			resultaat.add(new StripfiguurDTO(stripfiguur));
		}
		return resultaat;
	}

	public Collection<StripfiguurDTO> geefAlleStripfiguren() {
		return geefStripfiguren(stripfiguurRepo.geefAlleStripfiguren());
	}

	public Collection<StripfiguurDTO> geefAlleStripfigurenGesorteerdOpNaam() {
		return geefStripfiguren(stripfiguurRepo.geefStripfigurenGesorteerdOpNaam());
	}

	public Collection<StripfiguurDTO> geefAlleStripfigurenAflopendGesorteerdOpGrootte() {
		return geefStripfiguren(stripfiguurRepo.geefStripfigurenAflopendGesorteerdOpGrootte());
	}

	public Collection<StripfiguurDTO> geefAlleStripfigurenZonderDubbels() {
		return geefStripfiguren(stripfiguurRepo.geefStripfigurenZonderDubbels());
	}

	public Collection<StripfiguurDTO> geefDrieWillekeurigeStripfiguren() {
		return geefStripfiguren(stripfiguurRepo.geefDrieWillekeurigeStripfiguren());
	}

	public void voegDeExtraStripfigurenToe() {
		stripfiguurRepo.voegExtraStripfigurenToe();
	}
}
