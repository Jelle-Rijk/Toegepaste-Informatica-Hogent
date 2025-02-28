package domein;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import persistentie.ContainerMapper;

public class ContainerRepository {
	private ContainerMapper mapper;
	private List<Container> containers;

	public ContainerRepository() {
		mapper = new ContainerMapper();
		containers = mapper.getContainers();
	}

	public Collection<Container> getContainers() {
		return containers;
	}

	public Collection<Container> geefAlleContainersGesorteerdOpSerienummer() {
		Collections.sort(containers);
		return containers;
	}

	public Collection<Container> geefAlleContainersGesorteerdOpMassa() {
		Collections.sort(containers, new Comparator<Container>() {
			@Override
			public int compare(Container c1, Container c2) {
				return c1.getMassa() - c2.getMassa();
			}
		});
		return containers;
	}

	public Collection<Container> geefAlleContainersGesorteerdOpEigenaar() {
		Collections.sort(containers, (Container c1, Container c2) -> {
			return c1.getEigenaar().compareTo(c2.getEigenaar());
		});
		return containers;
	}

	public Collection<Container> geefAlleContainersGesorteerdOpVolumeEnEigenaar() {
		Collections.sort(containers, new ContainerVolumeEnEigenaarComparator());
		return containers;
	}

	public Collection<Container> geefAlleContainersGesorteerdOpAflopendSerienummer() {
		Collections.sort(containers, Comparator.comparing(Container::getSerienummer).reversed());
		return containers;
	}
	public Collection<Container> geefAlleContainersGesorteerdOpSerienummerReferentie() {
		Collections.sort(containers, Comparator.comparing(Container::getSerienummer));
		return containers;
	}
	
	public void voegContainerToe(Container c) {
		if (containers.contains(c))
			throw new IllegalArgumentException(
					String.format("Container met serienummer %d bestaat reeds", c.getSerienummer()));
		mapper.voegContainerToe(c);
		containers = mapper.getContainers();
	}

}
