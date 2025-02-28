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
		// TO DO
		return null;
	}

	public Collection<AutoDTO> geefAutosOpMerk() {
		// TO DO
		return null;
	}

	public Collection<AutoDTO> geefAutosOpMerkEnModel() {
		// TO DO
		return null;
	}

	public Collection<AutoDTO> geefAutosOpAantalOnderhoudsbeurtenAflopend() {
		// TO DO
		return null;
	}

	private Collection<AutoDTO> zetAutosOmNaatAutoDTOs(List<Auto> autos) {
		Collection<AutoDTO> autoDTOs = new ArrayList<>();
		for (Auto auto : autos) {
			autoDTOs.add(new AutoDTO(auto));
		}
		return autoDTOs;
	}

}
