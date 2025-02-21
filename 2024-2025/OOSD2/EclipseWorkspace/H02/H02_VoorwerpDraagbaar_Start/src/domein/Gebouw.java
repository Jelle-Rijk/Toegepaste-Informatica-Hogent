package domein;

public class Gebouw implements Draagbaar {
	private final String naam;
	private double hoogte;
	private final static double MIN_HOOGTE = 3;
	
//	CONSTRUCTOR
	public Gebouw(String naam, double hoogte) {
		controleerNaam(naam);
		this.naam = naam;
		setHoogte(hoogte);
	}
	
//	GETTERS - SETTERS
	public double getHoogte() {
		return hoogte;
	}
	
	public void setHoogte(double hoogte) {
		if (hoogte < MIN_HOOGTE)
			throw new IllegalArgumentException(String.format("De hoogte moet minimaal %.0f zijn.", MIN_HOOGTE));
		this.hoogte = hoogte;
	}
	
	public String getNaam() {
		return naam;
	}
	
	
//	PRIVATE METHODS
	private void controleerNaam(String naam) {
		if (naam == null || naam.isBlank())
			throw new IllegalArgumentException("Een gebouw moet een naam hebben.");
	}
	
	//	PUBLIC METHODS
	public boolean isDraagbaar() {
		return false;
	}
}
