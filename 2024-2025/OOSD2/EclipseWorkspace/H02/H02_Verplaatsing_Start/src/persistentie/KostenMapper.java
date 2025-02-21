package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Kost;
import domein.Ticket;
import domein.VerplaatsingPerAuto;
import domein.VerplaatsingPerBusTram;

public class KostenMapper {

	public List<Kost> geefKosten() {
		List<Kost> kosten = new ArrayList<>();

		kosten.add(new VerplaatsingPerBusTram("Voskenslaan Gent", "Veldstraat Gent", 4.2, 1, false, true));
		kosten.add(new Ticket("Parkeerticket Flanders Expo", 5));
		kosten.add(new VerplaatsingPerAuto("Gent", "Oudenaarde", 29.4, 1.591, 0.0538));
		kosten.add(new Ticket("Toegangsticket beurs", 10));
		kosten.add(new VerplaatsingPerBusTram("Laarne dorp", "Gent Sint-Pieters", 14.6, 34, true, false));
		kosten.add(new VerplaatsingPerAuto("Gent", "Brussel", 53.7, 1.488, 0.0692));
		kosten.add(new VerplaatsingPerAuto("Gent", "Kortrijk", 47.1, 1.649, 0.034));

		return kosten;
	}

}
