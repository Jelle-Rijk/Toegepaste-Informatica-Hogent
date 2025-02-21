package domein;

import java.util.Comparator;

public class ContainerEigenaarComparator implements Comparator<Container>{

	@Override
	public int compare(Container o1, Container o2) {
		return o1.getEigenaar().compareTo(o2.getEigenaar());
	}	
}