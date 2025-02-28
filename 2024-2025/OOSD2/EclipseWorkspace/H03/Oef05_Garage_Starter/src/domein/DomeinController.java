package domein;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dto.AutoDTO;

public class DomeinController {
	private final Garage garage;

	public DomeinController() {
		garage = new Garage();
	}

	public Collection<AutoDTO> geefAutosOpNummerplaat() {
		garage.sorteerOpNummerplaat();
		return zetAutosOmNaarAutoDTOs(garage.getAutos());
	}

	public Collection<AutoDTO> geefAutosOpMerk() {
		garage.sorteerOpMerk();
		return zetAutosOmNaarAutoDTOs(garage.getAutos());
	}

	public Collection<AutoDTO> geefAutosOpMerkEnModel() {
		garage.sorteerOpMerkEnModel();
		return zetAutosOmNaarAutoDTOs(garage.getAutos());
	}

	public Collection<AutoDTO> geefAutosOpAantalOnderhoudsbeurtenAflopend() {
		garage.sorteerOpAantalOnderhoudsbeurtenAflopend();
		return zetAutosOmNaarAutoDTOs(garage.getAutos());
	}

	private Collection<AutoDTO> zetAutosOmNaarAutoDTOs(List<Auto> autos) {
		Collection<AutoDTO> autoDTOs = new ArrayList<>();
		for (Auto auto : autos) {
			autoDTOs.add(new AutoDTO(auto));
		}
		return autoDTOs;
	}

}
