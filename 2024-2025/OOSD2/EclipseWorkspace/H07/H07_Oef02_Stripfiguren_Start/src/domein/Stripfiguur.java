package domein;

import java.util.Objects;

public class Stripfiguur {
	private final String naam;
	private final double grootte;

	public Stripfiguur(String naam, double grootte) {
		controleerNaam(naam);
		controleerGrootte(grootte);
		this.naam = naam;
		this.grootte = grootte;
	}

	public String getNaam() {
		return naam;
	}

	public double getGrootte() {
		return grootte;
	}

	private void controleerNaam(String naam) {
		if (naam == null || naam.isBlank())
			throw new IllegalArgumentException("Naam moet opgegeven worden");
	}

	private void controleerGrootte(double grootte) {
		if (grootte <= 0)
			throw new IllegalArgumentException("Grootte moet groter dan 0 zijn");
	}

	@Override
	public String toString() {
		return String.format("%s, %dcm groot", naam, (int) (grootte * 100));
	}

	@Override
	public int hashCode() {
		return Objects.hash(grootte, naam);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stripfiguur other = (Stripfiguur) obj;
		return Double.doubleToLongBits(grootte) == Double.doubleToLongBits(other.grootte)
				&& Objects.equals(naam, other.naam);
	}

}
