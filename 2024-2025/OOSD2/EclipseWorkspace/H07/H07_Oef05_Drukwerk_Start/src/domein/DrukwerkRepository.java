package domein;

import java.util.Collection;
import java.util.List;
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
		return null;
	}
	
	/** TODO
	 * Geef de gemiddelde prijs terug van 
	 * alle drukwerken waarvan hun prijs verschillend is van GEEN_PRIJS.
	 */
	public double geefGemiddeldePrijs()
	{
		return 0;
	}
	
	/** TODO 
	 * Sorteer de lijst volgens info in alfabetisch omgekeerde volgorde, bij gelijke
	 * info volgens oplage in stijgende volgorde.
	 * De originele lijst wordt niet gewijzigd.
	 */
	public List<Drukwerk> sorteerDrukwerken()
	{
		return null;	
	}


	/** TODO
	 * Voeg alle nieuwe releases (zie DrukwerkMapper) toe in lijst in één instructie.
	 */
	public void voegNieuweReleasesToe() 
	{
				
	}
	
	/** TODO
	 * Bepaal het Drukwerk met de hoogste oplage uit alle nieuwe releases (zie DrukwerkMapper)
	 */
	public Drukwerk geefHoogsteOplageNieuweReleases()
	{
		return null;
	}


	public List<Drukwerk> getLijst() {
		return lijst;
	}
	
	
}
