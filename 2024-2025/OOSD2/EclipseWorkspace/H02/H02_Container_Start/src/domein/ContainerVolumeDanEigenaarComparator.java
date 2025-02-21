package domein;

import java.util.Comparator;

public class ContainerVolumeDanEigenaarComparator implements Comparator<Container> {

	@Override
	public int compare(Container o1, Container o2) {
		int volumeCmp = o1.getVolume() - o2.getVolume();
		return volumeCmp == 0 ? new ContainerEigenaarComparator().compare(o1, o2): volumeCmp;
	}

}
