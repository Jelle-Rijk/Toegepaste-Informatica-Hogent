package domein;

import java.util.*;
import java.util.stream.Collectors;

public class SportclubController {

    private SporterBeheerder sporterBeheerder;

    public SportclubController() {
        sporterBeheerder = new SporterBeheerder();
    }

    // OEF MAP VRAAG 2.2
    public String geefSportersMetEvenveelReductiebonnen(int sporterLidNr) {
        Sporter sporter = sporterBeheerder.geefSporter(sporterLidNr);
        if (sporter == null)
            return "Ongekend lidnummer";
        List<Sporter> sportersMetEvenVeelBonnen = sporterBeheerder.geefSportersMetEvenveelReductiebonnen(sporter);
        return sportersMetEvenVeelBonnen.size() == 1 ? "Geen sporters met gelijk aantal kortingsbonnen" :
                sportersMetEvenVeelBonnen.stream().map(Sporter::getNaam).collect(Collectors.joining("-"));
    }


    // OEF GENERICS VRAAG 2
    public <T extends Comparable<T>> String geefGesorteerdeCollectie(Collection<T> collection) {
        return collection.stream().map(Object::toString).collect(Collectors.joining("\n"));

    }

    // OEF GENERICS VRAAG 3
    public String geefSporters() {
        return geefGesorteerdeCollectie(sporterBeheerder.getSportersLijst());
    }

    public String geefSportersPerLidnr() {
    	return sporterBeheerder.geefSportersPerLidnr();
	}

	public String geefSportersPerAantalReductiebonnen() {
		return sporterBeheerder.geefSportersPerAantalReductiebonnen();
	}

}
