package ui;

import domein.DomeinController;
import dto.KostDTO;

public class KostenApp {
	DomeinController dc;

	public KostenApp(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		System.out.println("Volgende documenten werden ingediend:");
		System.out.println(dc.geefOverzichtAantalDocumenten());
		toonOverzichtKosten();
		System.out.printf("%nTotaal gedeclareerde kosten =  %.2f", dc.berekenTotaalKosten());
	}

	private void toonOverzichtKosten() {
		System.out.printf("%nOverzicht gemaakte kosten:%n%n%70s%15s%n", "Kostenpost", "Bedrag");
		for (KostDTO k : dc.geefKostenLijst()) {
			System.out.printf("%70s%15.2f%n", geefKostenpost(k), k.prijs());
		}
		System.out.println();
	};
	
	private String geefKostenpost(KostDTO k) {
		if (k.soort() == 'T')
			return k.omschrijving();
		String kostenpost = String.format("verplaatsing van %s naar %s ", k.van(), k.naar());
		if (k.soort() == 'A')
			return kostenpost += "per auto";
		if (k.soort() == 'B') {
			return kostenpost += String.format("met %s%s %d", k.stadslijn()? "": "stads", k.bus()? "bus" : "tram", k.lijnnr());
		}
		throw new IllegalArgumentException("KostDTO heeft een onbestaande soort");
	}

}
