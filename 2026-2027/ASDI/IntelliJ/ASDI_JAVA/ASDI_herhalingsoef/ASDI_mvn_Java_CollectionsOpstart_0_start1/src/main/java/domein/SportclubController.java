package domein;

public class SportclubController {

	private SporterBeheerder sporterBeheerder;

	public SportclubController() {
		sporterBeheerder = new SporterBeheerder();
	}

	// OEF MAP VRAAG 2.2	
	public String geefSportersMetEvenveelReductiebonnen(int sporterLidNr) {
		throw new UnsupportedOperationException();
	}
	

	// OEF GENERICS VRAAG 2
	//geefGesorteerdeCollectie
	
	// OEF GENERICS VRAAG 3
	public String geefSporters() {
		throw new UnsupportedOperationException();	
	}
	
//TODO uncomment OEF GENERICS VRAAG 4
/*
    public String geefSportersPerLidnr() {
    	return sporterBeheerder.geefSportersPerLidnr();
	}

	public String geefSportersPerAantalReductiebonnen() {
		return sporterBeheerder.geefSportersPerAantalReductiebonnen();
	}
*/

}
