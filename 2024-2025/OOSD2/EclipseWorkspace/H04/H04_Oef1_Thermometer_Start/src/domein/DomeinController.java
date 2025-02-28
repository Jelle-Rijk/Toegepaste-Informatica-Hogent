package domein;

public class DomeinController
{
	private Thermometer t = new Thermometer();
	
	public void updateTemperatuur(int tempF)
	{
		t.setAantalGraden(tempF);
	}

	public int geefTemperatuurInCelsius()
	{
		return t.converteerNaarCelsius();
	}
}
