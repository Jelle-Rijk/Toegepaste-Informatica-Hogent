package domein;

public class DomeinController {
	private Thermometer t;

	public void updateTemperatuur(int tempF) {
		if (t == null)
			t = new Thermometer();
		t.setAantalGraden(tempF);
	}

	public int geefTemperatuurInCelsius() {
		return t.converteerNaarCelsius();
	}
}
