package domein;

import java.util.Collection;
import java.util.stream.Collectors;

import dto.BierDTO;
import persistentie.BierMapper;

public class DomeinController {

	private final BierWinkel bierWinkel;

	public DomeinController() {
		bierWinkel = new BierWinkel(new BierMapper().geefBieren());
	}

	public int geefAantalBierenMetMinAlcoholPercentage(double percentage) {
		return bierWinkel.geefAantalBierenMetMinAlcoholPercentage(percentage);
	}

	public Collection<BierDTO> geefLijstAlleBierenMetMinAlcoholPercentage(double percentage) {
		Collection<Bier> bieren = bierWinkel.geefAlleBierenMetMinAlcoholPercentage(percentage);
		return bieren.stream().map(BierDTO::new).collect(Collectors.toList());
	}

	public Collection<String> geefNamenBieren() {
		return bierWinkel.geefNamenBieren();
	}

	public Collection<String> geefAlleNamenBrouwerijen() {
		return bierWinkel.geefAlleNamenBrouwerijen();
	}

	public BierDTO geefBierMetHoogsteAlcoholPercentage() {
		return new BierDTO(bierWinkel.geefBierMetHoogsteAlcoholPercentage());
	}

	public BierDTO geefBierMetLaagsteAlcoholPercentage() {
		return new BierDTO(bierWinkel.geefBierMetLaagsteAlcoholPercentage());
	}

	public Collection<BierDTO> sorteerOpAlcoholGehalteEnNaam() {
		Collection<Bier> bieren = bierWinkel.geefBierenGesorteerdOpAlcoholGehalteEnNaam();
		return bieren.stream().map(BierDTO::new).collect(Collectors.toList());
	}

	public Collection<String> geefAlleNamenBrouwerijenMetWoord(String woord) {
		return bierWinkel.geefAlleNamenBrouwerijenMetWoord(woord);
	}

}
