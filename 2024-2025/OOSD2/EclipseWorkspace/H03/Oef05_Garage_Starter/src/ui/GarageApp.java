package ui;

import java.util.Collection;

import domein.DomeinController;
import dto.AutoDTO;

public class GarageApp {
	private final DomeinController domeinController;

	public GarageApp(DomeinController dc) {
		domeinController = dc;
	}

	public void start() {
		toonAutos("Alle auto's oplopend op nummerplaat:", domeinController.geefAutosOpNummerplaat());
		toonAutos("Alle auto's oplopend op merk:", domeinController.geefAutosOpMerk());
		toonAutos("Alle auto's oplopend op merk en model:", domeinController.geefAutosOpMerkEnModel());
		toonAutos("Alle auto's aflopend op aantal onderhoudsbeurten:",
				domeinController.geefAutosOpAantalOnderhoudsbeurtenAflopend());
	}

	private void toonAutos(String titel, Collection<AutoDTO> autos) {
		System.out.printf("%s%n", titel);
		System.out.printf("%s%n", "=".repeat(titel.length()));
		if (autos == null || autos.size() == 0) {
			System.out.println("Geen autos\n");
			return;
		}
		for (AutoDTO autoDTO : autos) {
			System.out.printf("%s %s met nummerplaat %s, %d onderhoudsbeurt%s%n", autoDTO.merk(), autoDTO.model(),
					autoDTO.nummerplaat(), autoDTO.aantalOnderhoudsbeurten(),
					autoDTO.aantalOnderhoudsbeurten() == 1 ? "" : "en");

		}
		System.out.println();
	}

}
