package domein;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import persistentie.VliegmaatschappijMapper;

public class VliegmaatschappijRepository {
	private final List<Vliegmaatschappij> maatschappijen;
	private final VliegmaatschappijMapper vm;

	public VliegmaatschappijRepository() {
		vm = new VliegmaatschappijMapper();
		maatschappijen = vm.geefLijstVliegmijen();
	}

	public List<Vliegmaatschappij> getMaatschappijen() {
		return maatschappijen;
	}

	/**
	 * @param minAantal het gewenste minimum aantal partners
	 * @return een lijst met de maatschappijen met minstens minAantal partners
	 */
	public Collection<Vliegmaatschappij> geefMaatschappijenMetPartners(int minAantal) {
		return maatschappijen.stream().filter(e -> e.getPartners().size() >= minAantal).toList();
	}

	/**
	 * @return een lijst met alle maatschappijen alfabetisch gesorteerd op naam
	 */
	public Collection<Vliegmaatschappij> geefAirlinesAlfabetischGesorteerd() {
		return maatschappijen.stream().sorted(Comparator.comparing(Vliegmaatschappij::getNaam)).toList();
	}

	/**
	 * @return een lijst met alle maatschappijen stijgend gesorteerd op aantal
	 *         partners
	 */
	public Collection<Vliegmaatschappij> geefAirlinesGesorteerdVolgensAantalPartners() {
		return maatschappijen.stream().sorted((m1, m2) -> Integer.compare(m1.getPartners().size(), m2.getPartners().size())).toList();
	}

	/**
	 * @param startTekst een string met de gewenste start tekst
	 * @return de naam van de eerste maatschappij wiens naam start met startTekst;
	 *         'niet bestaande' indien er geen maatschappij bestaat wiens naam start
	 *         met startTekst
	 */
	public String geefEersteAirlineStartendMet(String startTekst) {
		return maatschappijen.stream().filter(e -> e.getNaam().startsWith(startTekst)).map(Vliegmaatschappij::getNaam).findFirst().orElse("niet bestaande");
	}

	/**
	 * @param partner een string die de naam van een partner bevat
	 * @return een maatschappij die de opgegeven partner heeft; null indien er geen
	 *         maatschappij met de opegegeven partner is
	 */
	public Vliegmaatschappij geefEenAirlineMetPartner(String partner) {
		return maatschappijen.stream().filter(m -> m.isPartner(partner)).findFirst().orElse(null);
	}

}
