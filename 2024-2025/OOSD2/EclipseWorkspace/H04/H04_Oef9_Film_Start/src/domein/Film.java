package domein;

import java.util.Objects;

import exceptions.LegeStringException;

public class Film implements Vertoonbaar {

	private int sterren;
    private String naam;
    private int jaar;
    public static final int HUIDIG_JAAR = 2022;  //LocalDate.now().getYear(); --> probleem in testklasse
    public static final int MIN_STERREN = 0;
    public static final int MAX_STERREN = 5;
    public static final int MIN_JAAR = 1900;
    
    // Constructor 
    public Film(String naam, int sterren, int jaar) throws LegeStringException {
        setNaam(naam);
        setSterren(sterren);
        setJaar(jaar);
    }

	@Override
	public String toString() {
		return String.format("%s %s - %d - %d",
				 this.getClass().getSimpleName(),naam, sterren, jaar);
	}
	
    // Getters & setters 
	public int getSterren() {
		return sterren;
	}

	private void setSterren(int sterren) {
		if (sterren < MIN_STERREN || sterren > MAX_STERREN)
			throw new IllegalArgumentException(String.format("Aantal sterren voor een film ligt in het interval [%d,%d]", MIN_STERREN,MAX_STERREN));
		this.sterren = sterren;
	}

	public String getNaam() {
		return naam;
	}

	private void setNaam(String naam) throws LegeStringException {
		if (naam == null || naam.isBlank())
			throw new LegeStringException("Naam van de film mag niet leeg zijn.");
		this.naam = naam;
	}

	public int getJaar() {
		return jaar;
	}

	private void setJaar(int jaar) {
		if (jaar < MIN_JAAR || jaar > HUIDIG_JAAR)
			throw new IllegalArgumentException(String.format("Het jaar waarin de film uitkomt moet in het interval [1900 - %d] liggen", HUIDIG_JAAR));
		this.jaar = jaar;
	}

	@Override
	public int hashCode() {
		return Objects.hash(jaar, naam);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return jaar == other.jaar && Objects.equals(naam, other.naam);
	}

	@Override
	public int wordtVertoondInZaal()
	{
		if (sterren > 3)
			return 1;
		if (sterren == 3)
			return 2;
		return 3;
	}
}


