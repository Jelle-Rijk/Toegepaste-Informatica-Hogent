package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Vliegmaatschappij {
	private final String naam;
	private final List<String> partners;

	public Vliegmaatschappij(String naam, String[] partners) {
		if (naam == null || naam.isEmpty()) {
			throw new IllegalArgumentException("Geen geldige naam!");
		}
		this.naam = naam;
		this.partners = new ArrayList<>(Arrays.asList(partners));
	}

	public Collection<String> getPartners() {
		return partners;
	}

	public boolean isPartner(String naam) {
		return partners.contains(naam);
	}

	public String getNaam() {
		return naam;
	}

}
