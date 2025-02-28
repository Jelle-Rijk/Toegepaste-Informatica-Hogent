package dto;

import domein.Auto;

public record AutoDTO(String nummerplaat, String merk, String model, int aantalOnderhoudsbeurten) {
	public AutoDTO(Auto auto) {
		this(auto.getNummerplaat(), auto.getMerk(), auto.getModel(), auto.getAantalOnderhoudsbeurten());
	}
}
