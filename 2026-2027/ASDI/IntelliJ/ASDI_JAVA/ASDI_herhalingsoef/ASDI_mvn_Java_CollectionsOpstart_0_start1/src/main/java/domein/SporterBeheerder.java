package domein;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import repository.SporterDao;
import repository.SporterDaoJpa;

public class SporterBeheerder {

	private final SporterDao sporterDao;
	private final List<Sporter> sportersLijst;

	// TODO OEF MAP VRAAG 1 attributen
	//sportersPerLidnummer
	//sportersPerAantalReductiebonnen	
	
	public SporterBeheerder() {
		sporterDao = new SporterDaoJpa();
		sportersLijst = sporterDao.findAll();
		// OEF MAP
		maakOverzichten();
	}

	public Collection<Sporter> getSportersLijst() {
		return Collections.unmodifiableCollection(sportersLijst);
	}

	public Sporter geefEenSporterMetGegevenReductiebon(Reductiebon bon) {
		return sportersLijst.stream().filter(sporter -> sporter.getReductiebonLijst().contains(bon)).findAny()
				.orElse(null);
	}

	public List<Reductiebon> geefAlleReductiebonnenMetKortingsPercentageX(List<Integer> kortingspercentage) {
		return sportersLijst.stream().map(Sporter::getReductiebonLijst).flatMap(Collection::stream)
				.filter(bon -> kortingspercentage.contains(bon.getPercentage())).collect(Collectors.toList());
	}

	public void verwijderAlleSportersMetReductiebonMetPercX(int perc) {
		sportersLijst.removeIf(s -> s.getReductiebonLijst().stream().
				anyMatch(bon -> bon.getPercentage()==perc));
	}

	
	// OEF MAP VRAAG 1
	public void maakOverzichten() {
		//TODO
	}

	// OEF MAP VRAAG 2.1
	public Sporter geefSporter(int sporterLidNr) {
		throw new UnsupportedOperationException();
	}
	
	// OEF MAP VRAAG 2.1
	public List<Sporter> geefSportersMetEvenveelReductiebonnen(Sporter sporter) {
		throw new UnsupportedOperationException();	
	}
	
	// OEF GENERICS VRAAG 1
    // methode geefAlleSleutelsWaarden
	
	public String geefSportersPerLidnr() {
		throw new UnsupportedOperationException();
	}

	public String geefSportersPerAantalReductiebonnen() {
		throw new UnsupportedOperationException();
	}
    
	

}
