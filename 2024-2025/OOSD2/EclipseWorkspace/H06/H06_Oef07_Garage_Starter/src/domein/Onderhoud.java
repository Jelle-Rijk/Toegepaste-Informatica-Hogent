package domein;

import java.time.LocalDate;

public class Onderhoud {
	private LocalDate begindatum;
	private LocalDate einddatum;
	private Auto auto;

	public Onderhoud(LocalDate begindatum, LocalDate einddatum, Auto auto) {
		if (begindatum.isAfter(einddatum))
			throw new IllegalArgumentException("Einddatum onderhoud mag niet voor begindatum liggen");
		this.begindatum = begindatum;
		this.einddatum = einddatum;
		setAuto(auto);
	}

	public final void setEinddatum(LocalDate einddatum) {
		this.einddatum = einddatum;
	}

	private void setAuto(Auto auto) {
		if (auto == null)
			throw new IllegalArgumentException("Je moet een auto opgeven voor het onderhoud");
		this.auto = auto;
	}

	public LocalDate getBegindatum() {
		return begindatum;
	}

	public LocalDate getEinddatum() {
		return einddatum;
	}

	public Auto getAuto() {
		return auto;
	}

	/**
	 * Controleert of dit onderhoud grenst aan een ander onderhoud. Een onderhoud is
	 * aangrenzend aan een ander onderhoud indien
	 * 
	 * - beide onderhouden voor dezelfde auto zijn
	 * 
	 * - de beginDatum van het ene onderhoud exact 1 dag verder ligt dan de
	 * einddatum van het ander onderhoud
	 * 
	 * @param anderOnderhoud het onderhoud waarvan gecheckt moet worden of het
	 *                       aangrenzend is met dit onderhoud
	 */

	public boolean isAangrenzendMet(Onderhoud anderOnderhoud) {
		return false;
	}

}
