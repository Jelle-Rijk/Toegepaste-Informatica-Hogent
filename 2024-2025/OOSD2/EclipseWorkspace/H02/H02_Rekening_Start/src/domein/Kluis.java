package domein;

public class Kluis implements Beheerskost {
	private static final double JAARLIJKSE_KOST = 29;
	private final String houder;
	private final int kluisnummer;

//	CONSTRUCTOR
	public Kluis(String houder, int kluisnummer) {
		this.houder = houder;
		this.kluisnummer = kluisnummer;
	}

//	GETTERS
	public String getHouder() {
		return houder;
	}

	public int getKluisnummer() {
		return kluisnummer;
	}
	
//	PUBLIC METHODS
	@Override
	public double geefJaarlijkseKost() {
		return JAARLIJKSE_KOST;
	}

}
