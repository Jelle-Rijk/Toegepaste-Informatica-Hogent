package ui;

import java.util.Collection;

import domein.DomeinController;
import dto.BierDTO;

public class BierApplicatie {

	private final DomeinController domeinController;

	public BierApplicatie(DomeinController dc) {
		this.domeinController = dc;
	}

	public void start() {
		System.out.println("======================================================");
		System.out.println(
				"Aantal bieren van minstens 8 graden:" + domeinController.geefAantalBierenMetMinAlcoholPercentage(8));
		System.out.printf("======================================================%n");

		System.out.printf("%n======================================================%n");
		System.out.println("Lijst met alle bieren van minstens 8 graden");
		toonLijstBieren(domeinController.geefLijstAlleBierenMetMinAlcoholPercentage(8));
		System.out.printf("======================================================%n");

		System.out.printf("%n======================================================%n");
		System.out.println("Namen van alle bieren");
		toonLijstStrings(domeinController.geefNamenBieren());
		System.out.printf("======================================================%n");

		System.out.printf("%n======================================================%n");
		System.out.println("Bier met hoogste aantal graden: "
				+ geefBierDTOAlsString(domeinController.geefBierMetHoogsteAlcoholPercentage()));
		System.out.printf("======================================================%n");

		System.out.printf("%n======================================================%n");
		System.out.println("Bier met laagste aantal graden: "
				+ geefBierDTOAlsString(domeinController.geefBierMetLaagsteAlcoholPercentage()));
		System.out.printf("======================================================%n");

		System.out.printf("%n======================================================%n");
		System.out.println("Bieren dalend gesorteerd op alcoholpercentage; dan op naam");
		toonLijstBieren(domeinController.sorteerOpAlcoholGehalteEnNaam());
		System.out.printf("======================================================%n");

		System.out.printf("%n======================================================%n");
		System.out.println("Alle brouwerijen");
		toonLijstStrings(domeinController.geefAlleNamenBrouwerijen());
		System.out.printf("======================================================%n");

		System.out.printf("%n======================================================%n");
		System.out.println("Alle brouwerijen die het woord \"van\" bevatten");
		toonLijstStrings(domeinController.geefAlleNamenBrouwerijenMetWoord("van"));
		System.out.printf("======================================================%n");
	}

	private String geefBierDTOAlsString(BierDTO bierDTO) {
		return String.format("naam = %s, soort = %s, brouwerij = %s, alcoholgehalte = %.2f, beoordeling = %.1f",
				bierDTO.naam(), bierDTO.soort(), bierDTO.brouwerij(), bierDTO.alcoholgehalte(), bierDTO.beoordeling());
	}

	private void toonLijstBieren(Collection<BierDTO> bierDTOs) {
		for (BierDTO bierDTO : bierDTOs) {
			System.out.println(geefBierDTOAlsString(bierDTO));
		}
	}

	private void toonLijstStrings(Collection<String> strings) {
		for (String string : strings) {
			System.out.println(string);
		}
	}
}
