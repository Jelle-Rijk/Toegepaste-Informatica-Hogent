package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Vliegmaatschappij;

public class VliegmaatschappijMapper {
	public List<Vliegmaatschappij> geefLijstVliegmijen() {
		List<Vliegmaatschappij> airlines = new ArrayList<>();

		airlines.add(new Vliegmaatschappij("Delta", new String[] { "Air Canada", "Aero Mexico", "Ocean Air" }));
		airlines.add(new Vliegmaatschappij("United",
				new String[] { "Aria", "Lufthansa", "Ocean Air", "Quantas", "British Airways" }));
		airlines.add(new Vliegmaatschappij("Northwest", new String[] { "Air Alaska", "BMI", "Avolar", "EVA Air" }));
		airlines.add(new Vliegmaatschappij("Canjet", new String[] { "Girjet" }));
		airlines.add(new Vliegmaatschappij("Air Canada", new String[] { "Areo Mexico", "Delta", "Air Alaska" }));
		airlines.add(new Vliegmaatschappij("Aero Mexico", new String[] { "Delta", "Air Canda", "British Airways" }));
		airlines.add(new Vliegmaatschappij("Ocean Air", new String[] { "Delta", "United", "Quantas", "Avolar" }));
		airlines.add(new Vliegmaatschappij("Aria", new String[] { "United", "Lufthansa" }));
		airlines.add(new Vliegmaatschappij("Lufthansa", new String[] { "United", "Aria", "EVA Air" }));
		airlines.add(new Vliegmaatschappij("Quantas", new String[] { "United", "Ocean Air", "AlohaAir" }));
		airlines.add(new Vliegmaatschappij("BMI", new String[] { "Northwest" }));
		airlines.add(new Vliegmaatschappij("Maxair", new String[] { "Southwest", "Girjet" }));
		airlines.add(new Vliegmaatschappij("Girjet", new String[] { "Southwest", "Canjet", "Maxair" }));
		airlines.add(new Vliegmaatschappij("British Airways", new String[] { "United", "Aero Mexico" }));
		airlines.add(new Vliegmaatschappij("Air Alaska", new String[] { "Northwest", "Air Canada" }));
		airlines.add(new Vliegmaatschappij("Avolar", new String[] { "Northwest", "Ocean Air" }));
		airlines.add(new Vliegmaatschappij("EVA Air", new String[] { "Northwest", "Luftansa" }));
		airlines.add(new Vliegmaatschappij("Southwest", new String[] { "Girjet", "Maxair" }));
		airlines.add(new Vliegmaatschappij("AlohaAir", new String[] { "Quantas" }));
		return airlines;
	}
}
