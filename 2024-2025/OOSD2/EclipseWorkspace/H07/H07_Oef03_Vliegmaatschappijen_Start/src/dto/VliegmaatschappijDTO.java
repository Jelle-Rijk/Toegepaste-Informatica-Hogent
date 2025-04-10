package dto;

import java.util.Collection;

import domein.Vliegmaatschappij;

public record VliegmaatschappijDTO(String naam, Collection<String> partners) {
	public VliegmaatschappijDTO(Vliegmaatschappij vliegmaatschappij) {
		this(vliegmaatschappij.getNaam(), vliegmaatschappij.getPartners());
	}
}
