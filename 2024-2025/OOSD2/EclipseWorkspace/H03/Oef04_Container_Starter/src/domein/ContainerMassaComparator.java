package domein;

import java.util.Comparator;

public class ContainerMassaComparator implements Comparator<Container> {
	@Override
	public int compare(Container c1, Container c2) {
		return c1.getMassa() - c2.getMassa();
	}
}