package ui;

import domein.DomeinController;
import java.util.Scanner;

public class ThermometerApplicatie
{
	private DomeinController dc;
	
	public ThermometerApplicatie(DomeinController dc)
	{
		this.dc = dc;
	}
	
    public void start()
    {
		Scanner s = new Scanner(System.in);
		int tempFahrenheit;
		System.out.print("Geef een gehele temperatuur in °F [14, 104]: ");
		tempFahrenheit = s.nextInt();
		dc.updateTemperatuur(tempFahrenheit);
		System.out.printf("De temperatuur in °C is %d%n", dc.geefTemperatuurInCelsius());
    }    
}
