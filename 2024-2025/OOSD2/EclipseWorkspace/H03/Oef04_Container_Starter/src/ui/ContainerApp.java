package ui;

import java.util.Collection;
import java.util.Scanner;

import domein.DomeinController;
import dto.ContainerDTO;

public class ContainerApp {
	DomeinController dc;

	public ContainerApp(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		toonContainers("Containers zonder sorteren", dc.geefAlleContainers());
		toonContainers("Containers bij natuurlijk sorteren (serienummer)",
				dc.geefAlleContainersGesorteerdOpSerienummer());
		toonContainers("Containers bij sorteren op massa", dc.geefAlleContainersGesorteerdOpMassa());
		toonContainers("Containers bij sorteren op eigenaar", dc.geefAlleContainersGesorteerdOpEigenaar());
		toonContainers("Containers bij sorteren op volume en dan op eigenaar",
				dc.geefAlleContainersGesorteerdOpVolumeEnEigenaar());
		toonContainers("Containers bij sorteren op serienummer",
				dc.geefAlleContainersGesorteerdOpSerienummerReferentie());
		toonContainers("Containers bij sorteren op serienummer (aflopend)",
				dc.geefAlleContainersGesorteerdOpAflopendSerienummer());
		voegContainersToe();
	}

	private void voegContainersToe() {
		Scanner invoer = new Scanner(System.in);
		System.out.print("Wil je nog een container toevoegen (ja/nee)? ");
		String antwoord = invoer.next();
		invoer.nextLine();
		while (antwoord.toLowerCase().equals("ja")) {
			ContainerDTO container = leesContainerIn();
			dc.voegContainerToe(container);
			System.out.print("Wil je nog een container toevoegen (ja/nee)? ");
			antwoord = invoer.next();
			invoer.nextLine();
		}
		toonContainers("Containers bij natuurlijk sorteren (serienummer)",
				dc.geefAlleContainersGesorteerdOpSerienummer());
	}

	private ContainerDTO leesContainerIn() {
		Scanner invoer = new Scanner(System.in);
		System.out.printf("Geef de gegevens voor de nieuwe container%n");
		System.out.print("Serienummer: ");
		int serienummer = invoer.nextInt();
		System.out.print("Eigenaar: ");
		String eigenaar = invoer.next();
		invoer.nextLine();
		System.out.print("Massa: ");
		int massa = invoer.nextInt();
		System.out.print("Volume: ");
		int volume = invoer.nextInt();
		return new ContainerDTO(eigenaar, massa, volume, serienummer);
	}

	private void toonContainers(String titel, Collection<ContainerDTO> containers) {
		System.out.printf("%s%n", titel);
		System.out.printf("%s%n", "=".repeat(titel.length()));
		if (containers == null || containers.size() == 0) {
			System.out.println("Geen containers\n");
			return;
		}
		System.out.printf("%15s %15s %15s %15s%n", "Serienummer", "Eigenaar", "Massa", "Volume");
		for (ContainerDTO containerDTO : containers) {
			System.out.printf("%15d %15s %15d %15d%n", containerDTO.serienummer(), containerDTO.eigenaar(),
					containerDTO.massa(), containerDTO.volume());

		}
		System.out.println();
	}
}