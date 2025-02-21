package domein;

import java.util.Comparator;

public class ContainerMassaComparator implements Comparator<Container> {

	@Override
	public int compare(Container o1, Container o2) {
		return o1.getMassa() - o2.getMassa();
	}

}
