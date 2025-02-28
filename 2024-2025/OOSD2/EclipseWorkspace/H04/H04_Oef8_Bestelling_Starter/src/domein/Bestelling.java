package domein;

public class Bestelling {
	public static final int MAX_ARTIKELEN = 8;
	public static final int MAX_PRINTERS = 4;
	public static final int MAX_SCANNERS = 3;
	public static final int MAX_LAPTOPS = 2;
	private int printers, laptops, scanners;

	public Bestelling(int printers, int laptops, int scanners) {
		setPrinters(printers);
		setLaptops(laptops);
		setScanners(scanners);
	}

	public int getPrinters() {
		return printers;
	}

	private void setPrinters(int printers) {
		this.printers = printers;
	}

	public int getLaptops() {
		return laptops;
	}

	private void setLaptops(int laptops) {
		this.laptops = laptops;
	}

	public int getScanners() {
		return scanners;
	}

	private void setScanners(int scanners) {
		this.scanners = scanners;
	}

	@Override
	public String toString() {
		return String.format("Bestelling van %d printers, %d laptops en %d scanners", printers, laptops, scanners);
	}
}
