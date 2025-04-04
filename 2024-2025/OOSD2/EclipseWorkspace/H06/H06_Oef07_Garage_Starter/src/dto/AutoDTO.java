package dto;

import domein.Auto;

public record AutoDTO(String merk, String model, String nummerplaat) {
	public AutoDTO(Auto auto) {
		this(auto.getMerk(), auto.getModel(), auto.getNummerplaat());
	}
}
