package domein;

public class ContainerVolumeEnEigenaarComparator extends ContainerEigenaarComparator {
	@Override
	public int compare(Container c1, Container c2) {
		int volumeComparison = c1.getVolume() - c2.getVolume();
		return volumeComparison == 0 ? super.compare(c1, c2) : volumeComparison;
	}
}
