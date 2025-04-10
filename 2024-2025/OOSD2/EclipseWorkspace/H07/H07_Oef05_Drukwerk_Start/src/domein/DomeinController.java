package domein;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DomeinController {

	private DrukwerkRepository drukwerkRepo;

	
	public DomeinController() {
		drukwerkRepo = new DrukwerkRepository();
	}

	public double geefGemiddeldePrijs() {
		return drukwerkRepo.geefGemiddeldePrijs();
	}

	public String geefInfosVolgensOplage(int oplage)
	{		
		return zetOmNaarString(drukwerkRepo.geefDrukwerkenVolgensOplage(oplage));
	}
	
	public String sorteerDrukwerken()
	{		
		return zetOmNaarString(drukwerkRepo.sorteerDrukwerken());
	}
	
	

	/** TODO - zetOmNaarString   
	 * Deze methode geeft een string terug, opgebouwd uit de tekstuele weergave van alle elementen
	 * uit de meegegeven collectie(argument).  
	 * De elementen van de lijst worden onder elkaar afgebeeld. 
	 * Je mag gebruik maken van toString om een element om te zetten naar een String. 	
	 */
	private String zetOmNaarString(Collection<Drukwerk> lijst) {
		return lijst.stream().map(Drukwerk::toString).collect(Collectors.joining("\n"));
	}

	public void voegNieuweReleasesToe() {
		drukwerkRepo.voegNieuweReleasesToe();		
	}
	
	public List<String> geefAlleDrukwerken()
	{
		List<Drukwerk> lijst = drukwerkRepo.getLijst();
		return lijst.stream()
				    .map(Drukwerk::toString)
				    .collect(Collectors.toList());
	}
	
	public long geefHoogsteOplageNieuweReleases()
	{
		return drukwerkRepo.geefHoogsteOplageNieuweReleases().getOplage();
	}
}
