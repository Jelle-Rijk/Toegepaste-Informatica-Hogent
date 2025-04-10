package ui;

import domein.DomeinController;


public class ConsoleApplicatie 
{
	private final DomeinController dc;
	
    public ConsoleApplicatie(DomeinController dc) 
    {
    	this.dc =dc;
    	start();
    	
    }

	private void start() {
		// TODO Auto-generated method stub
		System.out.println("DRUKWERKEN VOLGENS OPLAGE 5000:");
    	System.out.printf("%s%n%n", dc.geefInfosVolgensOplage(5000));
    	
    	System.out.println("GEMIDDELDE PRIJS:");
    	System.out.printf("%.2f %n%n", dc.geefGemiddeldePrijs());
    	
    	System.out.println("GESORTEERDE LIJST (volgens info in omgekeerde alfabetische volgorde, oplage stijgende volgorde:)");
    	System.out.printf("%s%n%n", dc.sorteerDrukwerken());
    	
    	dc.voegNieuweReleasesToe();
    	System.out.println("ALLE INFO'S: ");
    	dc.geefAlleDrukwerken().forEach(System.out::println);
    	
    	System.out.println("\nGESORTEERDE LIJST (volgens info in omgekeerde alfabetische volgorde, oplage stijgende volgorde:)");
    	System.out.printf("%s%n%n", dc.sorteerDrukwerken());
    	
    	System.out.println("HOOGSTE OPLAGE (nieuwe releases):");
    	System.out.printf("%d %n%n", dc.geefHoogsteOplageNieuweReleases());
		
	}
    

}
