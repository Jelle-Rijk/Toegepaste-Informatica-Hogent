package dto;

import domein.Bier;

public record BierDTO(String naam, String soort, String brouwerij, double alcoholgehalte, double beoordeling) {
	public BierDTO(Bier bier) {
		this(bier.getNaam(), bier.getSoort(), bier.getBrouwerij(), bier.getAlcoholgehalte(), bier.getBeoordeling());
	}
}
