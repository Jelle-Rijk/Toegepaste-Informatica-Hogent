package dto;

import domein.Kost;
import domein.Ticket;
import domein.VerplaatsingPerAuto;
import domein.VerplaatsingPerBusTram;

public record KostDTO(char soort, double prijs, String van, String naar, int lijnnr, boolean bus, boolean stadslijn, String omschrijving) {

	public static KostDTO maakKostDTO(Kost k) {
		if (k instanceof VerplaatsingPerAuto a) {
			return new KostDTO('A', a.berekenPrijsZonderBtw(), a.getVan(), a.getNaar(), 0, false, false, null);
		}
		if (k instanceof VerplaatsingPerBusTram bt) {
			return new KostDTO('B', bt.berekenPrijsZonderBtw(), bt.getVan(), bt.getNaar(), bt.getLijnnr(), bt.isBus(), bt.isStadslijn(), null);
		}
		if (k instanceof Ticket t) {
			return new KostDTO('T', t.berekenPrijs(), null, null, 0, false, false, t.getOmschrijving());
		}
		throw new IllegalArgumentException("Onbekende kost");
	}
}
