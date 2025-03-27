package ui;

import java.time.format.DateTimeFormatter;
import java.util.Collection;

import domein.DomeinController;
import dto.AutoDTO;
import dto.OnderhoudDTO;

public class GarageApp {
	private final DomeinController dc;

	public GarageApp(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		System.out.println("== Alle auto's gesorteerd op nummerplaat ==");
		toonAlleAutos(dc.geefAlleAutosInOnderhoud());
		System.out.printf("%n== Alle onderhouden voor sorteren ==%n");
		toonAlleOnderhouden(dc.geefAlleOnderhouden());
		dc.sorteerOnderhouden();
		System.out.printf("%n== Alle onderhouden na sorteren op nummerplaat - begindatum ==%n");
		toonAlleOnderhouden(dc.geefAlleOnderhouden());
		dc.voegAaneengrenzendeOnderhoudenSamen();
		System.out.printf("%n== Alle onderhouden na samenvoegen van aaneengrenzende onderhouden ==%n");
		toonAlleOnderhouden(dc.geefAlleOnderhouden());
	}

	private String geefAutoAlsString(AutoDTO autoDTO) {
		return String.format("%s %s met nummerplaat %s", autoDTO.merk(), autoDTO.model(), autoDTO.nummerplaat());
	}

	private void toonAlleAutos(Collection<AutoDTO> alleAutoDTOs) {
		for (AutoDTO autoDTO : alleAutoDTOs) {
			System.out.println(geefAutoAlsString(autoDTO));
		}
	}

	private void toonAlleOnderhouden(Collection<OnderhoudDTO> alleOnderhoudDTOs) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-uuuu");
		for (OnderhoudDTO onderhoudDTO : alleOnderhoudDTOs) {
			System.out.printf("Onderhoud voor %-40s van %s t.e.m. %s%n", geefAutoAlsString(onderhoudDTO.auto()),
					onderhoudDTO.begindatum().format(format), onderhoudDTO.einddatum().format(format));
		}
	}

}