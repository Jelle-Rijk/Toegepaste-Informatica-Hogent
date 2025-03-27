package domein;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import persistentie.OnderhoudMapper;

public class OnderhoudRepository {
	private final List<Onderhoud> onderhouden;

	public OnderhoudRepository() {
		onderhouden = new ArrayList<>(new OnderhoudMapper().geefOnderhoudVanAutos());
	}

	public Collection<Onderhoud> geefAlleOnderhouden() {
		return onderhouden;
	}
}
