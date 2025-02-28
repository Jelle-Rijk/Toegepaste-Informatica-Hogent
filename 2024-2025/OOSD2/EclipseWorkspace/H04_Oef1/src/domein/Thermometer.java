package domein;

public class Thermometer {
	private final static int DEFAULT_TEMP = 32;
	private int aantalGraden;

//	CONSTRUCTOR
	public Thermometer() {
		setAantalGraden(DEFAULT_TEMP);
	}

//	GETTERS / SETTERS
	public int getAantalGraden() {
		return aantalGraden;
	}

	public final void setAantalGraden(int aantalGraden) {
		this.aantalGraden = aantalGraden;
	}

	// PUBLIC METHODS
	public int converteerNaarCelsius() {
		int celsius = (aantalGraden - 32) * 5/9;
		return celsius;
	}

}
