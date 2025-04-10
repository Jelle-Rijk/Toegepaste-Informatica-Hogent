package domein;

public class Bier {

	private String naam, soort, brouwerij;
	private double alcoholgehalte, beoordeling;

	public Bier(String naam, String soort, double alcoholgehalte, double beoordeling, String brouwerij) {
		this.naam = naam;
		this.soort = soort;
		this.brouwerij = brouwerij;
		this.alcoholgehalte = alcoholgehalte;
		this.beoordeling = beoordeling;
	}

	public String getNaam() {
		return naam;
	}

	public String getSoort() {
		return soort;
	}

	public String getBrouwerij() {
		return brouwerij;
	}

	public double getAlcoholgehalte() {
		return alcoholgehalte;
	}

	public double getBeoordeling() {
		return beoordeling;
	}

}
