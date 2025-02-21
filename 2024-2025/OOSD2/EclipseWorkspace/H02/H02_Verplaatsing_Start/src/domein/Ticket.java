package domein;

public class Ticket implements Kost {
	public final static double BTW_PERCENTAGE = 6;
	private String omschrijving;
	private double prijs;

//	CONSTRUCTOR
	public Ticket(String omschrijving, double prijs) {
		setOmschrijving(omschrijving);
		setPrijs(prijs);
	}

//	GETTERS - SETTERS
	public String getOmschrijving() {
		return omschrijving;
	}

	public final void setOmschrijving(String omschrijving) {
		if (omschrijving == null || omschrijving.isBlank())
			throw new IllegalArgumentException(
					String.format("De omschrijving was %s.", omschrijving == null ? "null" : "leeg"));
		this.omschrijving = omschrijving;
	}

	public double getPrijs() {
		return prijs;
	}

	public final void setPrijs(double prijs) {
		if (prijs <= 0)
			throw new IllegalArgumentException("De prijs moet een strikt positief getal zijn.");
		this.prijs = prijs;
	}

	@Override
	public double berekenPrijs() {
		return getPrijs();
	}

	@Override
	public double berekenPrijsZonderBtw() {
		return (getPrijs() / (100 + BTW_PERCENTAGE)) * 100;
	}

}
