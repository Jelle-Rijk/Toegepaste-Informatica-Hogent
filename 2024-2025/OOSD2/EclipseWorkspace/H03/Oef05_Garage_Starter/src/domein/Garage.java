package domein;

import java.util.Collections;
import java.util.Comparator;
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
		Collections.sort(autos);
	}

	public void sorteerOpMerk() {
//		ANONYMOUS INNER CLASS
		Collections.sort(autos, new Comparator<Auto>() {
			@Override
			public int compare(Auto a1, Auto a2) {
				return a1.getMerk().compareTo(a2.getMerk());
			}
		});
	}

	public void sorteerOpMerkEnModel() {
//		LAMBDA
		Collections.sort(autos, (Auto a1, Auto a2) -> {
			if (a1.getMerk().equals(a2.getMerk())) {
				return a1.getModel().compareTo(a2.getModel());
			};
			return a1.getMerk().compareTo(a2.getMerk());
		});
	}

	public void sorteerOpAantalOnderhoudsbeurtenAflopend() {
//		METHOD REFERENCE
		Collections.sort(autos, Comparator.comparing(Auto::getAantalOnderhoudsbeurten).reversed());
	}

}
