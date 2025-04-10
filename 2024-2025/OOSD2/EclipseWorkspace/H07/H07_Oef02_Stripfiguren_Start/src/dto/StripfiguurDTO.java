package dto;

import domein.Stripfiguur;

public record StripfiguurDTO(String naam, double grootte) {
	public StripfiguurDTO(Stripfiguur stripfiguur) {
		this(stripfiguur.getNaam(), stripfiguur.getGrootte());
	}
}
