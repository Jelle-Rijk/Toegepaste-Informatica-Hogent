package persistentie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import domein.Auto;

public class AutoMapper {

	public Collection<Auto> geefAutos() {
		List<Auto> lijstAutos = new ArrayList<>();
		lijstAutos.add(new Auto("ABC-123", "Nissan", "Quashqai"));
		lijstAutos.add(new Auto("XYZ-000", "Opel", "Astra"));
		lijstAutos.add(new Auto("AABBCC", "BMW", "M4"));
		lijstAutos.add(new Auto("FUNNY", "Toyota", "HiAce"));
		lijstAutos.add(new Auto("789cde", "Skoda", "Fabia"));
		lijstAutos.add(new Auto("XYZ-333", "Renault", "Arkana"));
		lijstAutos.add(new Auto("HO-GENT", "Opel", "Zafira"));
		lijstAutos.add(new Auto("DEF-007", "Peugeot", "308"));
		return lijstAutos;
	}
}
