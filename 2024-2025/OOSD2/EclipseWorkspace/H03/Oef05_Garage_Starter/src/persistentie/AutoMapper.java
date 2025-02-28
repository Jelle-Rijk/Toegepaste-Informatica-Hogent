package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Auto;

public class AutoMapper {

	public List<Auto> geefLijstVanAutos() {
		List<Auto> lijstAutos = new ArrayList<>();
		lijstAutos.add(new Auto("123xyz", "Toyota", "Yaris", 6));
		lijstAutos.add(new Auto("456abc", "Opel", "Astra", 4));
		lijstAutos.add(new Auto("azerty", "BMW", "Berline", 0));
		lijstAutos.add(new Auto("qwerty", "Toyota", "Avensis", 8));
		lijstAutos.add(new Auto("789cde", "Mercedes", "C-klasse Berline", 2));
		lijstAutos.add(new Auto("567xyz", "Renault", "Fluence", 5));
		lijstAutos.add(new Auto("ab12ab", "Opel", "Zafira", 7));
		lijstAutos.add(new Auto("xy12xy", "Peugeot", "308", 9));

		return lijstAutos;
	}

}
