package domein;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import dto.VliegmaatschappijDTO;

public class DomeinController {
	private final VliegmaatschappijRepository vliegmijRepository;

	public DomeinController() {
		this.vliegmijRepository = new VliegmaatschappijRepository();
	}

	/**
	 * @param een verzameling vliegmaatschappijen
	 * @return een verzameling van vliegmaatschappijDTOs
	 */
	private Collection<VliegmaatschappijDTO> geefVliegmaatschappijDTOs(Collection<Vliegmaatschappij> maatschappijen) {
		return maatschappijen.stream().map(m -> new VliegmaatschappijDTO(m.getNaam(), m.getPartners())).collect(Collectors.toCollection(ArrayList::new));
	}

	public Collection<VliegmaatschappijDTO> geefAirlines() {
		return geefVliegmaatschappijDTOs(vliegmijRepository.getMaatschappijen());
	}

	public Collection<VliegmaatschappijDTO> geefAlleAirlinesMetMinstensAantalPartners(int minAantal) {
		return geefVliegmaatschappijDTOs(vliegmijRepository.geefMaatschappijenMetPartners(minAantal));
	}

	public Collection<VliegmaatschappijDTO> geefAirlinesAlfabetischGesorteerd() {
		return geefVliegmaatschappijDTOs(vliegmijRepository.geefAirlinesAlfabetischGesorteerd());
	}

	public Collection<VliegmaatschappijDTO> geefAirlinesGesorteerdVolgensAantalPartners() {
		return geefVliegmaatschappijDTOs(vliegmijRepository.geefAirlinesGesorteerdVolgensAantalPartners());
	}

	public String geefEersteAirlineStartendMet(String woord) {
		return vliegmijRepository.geefEersteAirlineStartendMet(woord);
	}

	public VliegmaatschappijDTO geefEenAirlineMetPartner(String partner) {
		Vliegmaatschappij resultaat = vliegmijRepository.geefEenAirlineMetPartner(partner);
		return resultaat == null ? null : new VliegmaatschappijDTO(resultaat);
	}

}
