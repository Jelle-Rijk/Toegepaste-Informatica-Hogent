package domein;

public class Auto {
	private final String nummerplaat;
	private final String merk;
	private final String model;

	public Auto(String nummerplaat, String merk, String model) {
		controleerOfAttribuutNietLeegIs("nummerplaat", nummerplaat);
		controleerOfAttribuutNietLeegIs("merk", merk);
		controleerOfAttribuutNietLeegIs("model", model);
		this.nummerplaat = nummerplaat;
		this.merk = merk;
		this.model = model;
	}

	private void controleerOfAttribuutNietLeegIs(String attribuut, String waarde) {
		if (waarde == null || waarde.isBlank())
			throw new IllegalArgumentException(String.format("%s moet een waarde hebben", attribuut));
	}

	public String getMerk() {
		return merk;
	}

	public String getModel() {
		return model;
	}

	public String getNummerplaat() {
		return nummerplaat;
	}

	// Twee auto zijn gelijk als dezelfde nummerplaat hebben
	// Override de methodes equals en hashCode uit Object
	// Zorg ook dat deze klasse de interface Comparable implementeert,
	// auto's worden op natuurlijke wijze alfabetisch gesorteerd op nummerplaat

}
