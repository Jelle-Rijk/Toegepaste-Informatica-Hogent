package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.ConcertRegistratie;
import domein.Film;
import domein.Vertoonbaar;

public class VertoonbaarMapper {

	public List<Vertoonbaar> geefAlleVoorstellingen(){
		
		List<Vertoonbaar> voorstellingen = new ArrayList<>();
		
		voorstellingen.add(new Film("film A",5,2020));
		voorstellingen.add(new ConcertRegistratie("artiest 1", "concert 1"));
		voorstellingen.add(new ConcertRegistratie("artiest 2", "concert 2"));
		voorstellingen.add(new Film("film B",3,2018));
		
		return voorstellingen;
	}
}
