package domein;

import java.util.List;

import persistentie.AutoMapper;

public class Garage {

	private final List<Auto> autos;

	public Garage() {
		autos = new AutoMapper().geefLijstVanAutos();
	}

	public List<Auto> getAutos() {
		return autos;
	}

	public void sorteerOpNummerplaat() {
		// TO DO
	}

	public void sorteerOpMerk() {
		// TO DO
	}

	public void sorteerOpMerkEnModel() {
		// TO DO
	}

	public void sorteerOpAantalOnderhoudsbeurtenAflopend() {
//    	//TO DO
	}

}
