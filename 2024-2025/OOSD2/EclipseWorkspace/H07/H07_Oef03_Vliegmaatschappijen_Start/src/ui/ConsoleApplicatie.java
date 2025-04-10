package ui;

import java.util.Collection;
import java.util.stream.Collectors;

import domein.DomeinController;
import dto.VliegmaatschappijDTO;

public class ConsoleApplicatie {
	public ConsoleApplicatie(DomeinController dc) {
		System.out.println("Alle vliegmaatschappijen:");
		System.out.println(geefAlleDTOsInEenString(dc.geefAirlines()));

		System.out.println("\nAlle vliegmaatschappijen met minstens 2 partners:");
		System.out.println(geefAlleDTOsInEenString(dc.geefAlleAirlinesMetMinstensAantalPartners(2)));

		System.out.println("\nAlle vliegmaatschappijen alfabetisch gesorteerd:");
		System.out.println(geefAlleDTOsInEenString(dc.geefAirlinesAlfabetischGesorteerd()));

		System.out.println("\nAlle vliegmaatschappijen gesorteerd volgens aantal partners:");
		System.out.println(geefAlleDTOsInEenString(dc.geefAirlinesGesorteerdVolgensAantalPartners()));

		System.out.println("\nEerste vliegmaatschappij in de lijst beginnend met A:");
		System.out.println(dc.geefEersteAirlineStartendMet("A"));

		System.out.println("\nEerste vliegmaatschappij in de lijst beginnend met ABC:");
		System.out.println(dc.geefEersteAirlineStartendMet("ABC"));

		System.out.println("\nEen vliegmaatschappij met partner Areo Mexico:");

		System.out.println(dtoToString(dc.geefEenAirlineMetPartner("Areo Mexico")));

		System.out.println("\nEen vliegmaatschappij met partner Onbestaand:");
		System.out.println(dc.geefEenAirlineMetPartner("Onbestaand"));

	}

	/**
	 * @param een verzameling vliegmaatschappijDTOs
	 * @return een String die alle DTOs, gescheiden door een new-line teken bevat;
	 *         je kan gebruik maken van de gegeven methode dtoToString
	 */

	private String geefAlleDTOsInEenString(Collection<VliegmaatschappijDTO> vmDTOs) {
		return vmDTOs.stream().map(d -> dtoToString(d)).collect(Collectors.joining("\n"));
	}

	private String dtoToString(VliegmaatschappijDTO vmDTO) {
		return String.format("%s met partners %s", vmDTO.naam(), vmDTO.partners());
	}

}
