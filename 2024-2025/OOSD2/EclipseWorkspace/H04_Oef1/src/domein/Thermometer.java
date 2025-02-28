package domein;

import exceptions.BuitenBereikException;

public class Thermometer {
	private final static int ONDERGRENS = 14;
	private final static int BOVENGRENS = 104;
	private int aantalGraden;

//	CONSTRUCTOR
	public Thermometer() {
		setAantalGraden(32);
	}

//	GETTERS / SETTERS
	public int getAantalGraden() {
		return aantalGraden;
	}

	private void setAantalGraden(int aantalGraden) {
		if (aantalGraden < ONDERGRENS || aantalGraden > BOVENGRENS)
			throw new BuitenBereikException();
		this.aantalGraden = aantalGraden;
	}

	// PUBLIC METHODS
	public int converteerNaarCelsius() {
		int celsius = (aantalGraden - 32) * 5 / 9;
		return celsius;
	}
	
	public void stelAantalGradenIn(String invoer) {
		setAantalGraden(Integer.parseInt(invoer));
	}

}
