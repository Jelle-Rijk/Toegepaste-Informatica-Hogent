package domein;

public class DomeinController {
	private Thermometer t;

	public void updateTemperatuur(String tempF) {
		if (t == null)
			t = new Thermometer();
		t.stelAantalGradenIn(tempF);
	}

	public int geefTemperatuurInCelsius() {
		return t.converteerNaarCelsius();
	}
}
