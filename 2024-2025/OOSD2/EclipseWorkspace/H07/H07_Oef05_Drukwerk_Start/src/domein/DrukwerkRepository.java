package domein;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import persistentie.DrukwerkMapper;

public class DrukwerkRepository {

	private final List<Drukwerk> lijst; 
	private final DrukwerkMapper drukwerkMapper;
	
	public DrukwerkRepository()
	{
		drukwerkMapper = new DrukwerkMapper();
		lijst = drukwerkMapper.initDrukwerkData();
	}
	
	
	/** TODO
	 * Geef alle unieke drukwerken (= geen dubbels) waarvan de oplage van het drukwerk
	 * kleiner of gelijk is aan de meegegeven oplage.
	 */
	public Collection<Drukwerk> geefDrukwerkenVolgensOplage(int oplage)
	{
		return lijst.stream().filter(d -> d.getOplage() <= oplage).distinct().collect(Collectors.toList());
	}
	
	/** TODO
	 * Geef de gemiddelde prijs terug van 
	 * alle drukwerken waarvan hun prijs verschillend is van GEEN_PRIJS.
	 */
	public double geefGemiddeldePrijs()
	{
		return lijst.stream().filter(d -> d.getPrijs() != d.GEEN_PRIJS).mapToDouble(Drukwerk::getPrijs).average().getAsDouble();
	}
	
	/** TODO 
	 * Sorteer de lijst volgens info in alfabetisch omgekeerde volgorde, bij gelijke
	 * info volgens oplage in stijgende volgorde.
	 * De originele lijst wordt niet gewijzigd.
	 */
	public List<Drukwerk> sorteerDrukwerken()
	{
		return lijst.stream().sorted(Comparator.comparing(Drukwerk::getInfo).reversed().thenComparing(Drukwerk::getOplage)).toList();	
	}


	/** TODO
	 * Voeg alle nieuwe releases (zie DrukwerkMapper) toe in lijst in ��n instructie.
	 */
	public void voegNieuweReleasesToe() 
	{
		lijst.addAll(Arrays.stream(drukwerkMapper.geefNieuweReleases()).toList());
	}
	
	/** TODO
	 * Bepaal het Drukwerk met de hoogste oplage uit alle nieuwe releases (zie DrukwerkMapper)
	 */
	public Drukwerk geefHoogsteOplageNieuweReleases()
	{
		return Arrays.stream(drukwerkMapper.geefNieuweReleases()).max(Comparator.comparing(Drukwerk::getOplage)).orElse(null);
	}


	public List<Drukwerk> getLijst() {
		return lijst;
	}
	
	
}
