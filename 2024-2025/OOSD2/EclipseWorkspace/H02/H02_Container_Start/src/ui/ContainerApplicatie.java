package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domein.Container;
import domein.ContainerEigenaarComparator;
import domein.ContainerMassaComparator;
import domein.ContainerVolumeDanEigenaarComparator;

public class ContainerApplicatie {

	public static void main(String[] args) {
		List<Container> containers = new ArrayList<>();

		containers.add(new Container("Antwerpen", 60, 150, 1234));
		containers.add(new Container("Rotterdam", 70, 110, 2568));
		containers.add(new Container("Calais", 80, 90, 8569));
		containers.add(new Container("Brugge", 70, 100, 8564));

		// Deel 1
		Collections.sort(containers);
		System.out.printf("%nContainers bij natuurlijk sorteren:%n");
		for (Container c : containers) {
			System.out.printf("%d - %dkg - %s - %dm³%n", c.getSerialNumber(), c.getMassa(), c.getEigenaar(),
					c.getVolume());
		}
		// Deel 2
		Collections.sort(containers, new ContainerMassaComparator());
		System.out.printf("%nContainers bij sorteren op massa:%n");
		for (Container c : containers) {
			System.out.printf("%dkg - %s - %dm³%n", c.getMassa(), c.getEigenaar(), c.getVolume());
		}
		// Deel 3
		Collections.sort(containers, new ContainerEigenaarComparator());
		System.out.printf("%nContainers bij sorteren op eigenaar:%n");
		for (Container c : containers) {
			System.out.printf("%s - %dm³ - %dkg%n", c.getEigenaar(), c.getVolume(), c.getMassa());
		}

		// Deel 4
		Collections.sort(containers, new ContainerVolumeDanEigenaarComparator());
		System.out.printf("%nContainers bij sorteren op volume en dan eigenaar:%n");
		for (Container c : containers) {
			System.out.printf("%dm³ - %s - %dkg%n", c.getVolume(), c.getEigenaar(), c.getMassa());
		}

	}
}