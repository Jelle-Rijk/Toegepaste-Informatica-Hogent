package dto;

import java.time.LocalDate;

import domein.Onderhoud;

public record OnderhoudDTO(AutoDTO auto, LocalDate begindatum, LocalDate einddatum) {

	public OnderhoudDTO(Onderhoud onderhoud) {
		this(new AutoDTO(onderhoud.getAuto()), onderhoud.getBegindatum(), onderhoud.getEinddatum());
	}
}
