package domein;

import exceptions.BestellingException;

public class Bestelling {
	public final static int MIN_ARTIKELEN = 1;
	public final static int MAX_ARTIKELEN = 8;
	public final static int MAX_PRINTERS = 4;
	public final static int MAX_SCANNERS = 3;
	public final static int MAX_LAPTOPS = 2;

	private int printers;
	private int scanners;
	private int laptops;

	public Bestelling(int printers, int scanners, int laptops) throws BestellingException {
		setPrinters(printers);
		setScanners(scanners);
		setLaptops(laptops);
		if (printers + scanners + laptops > MAX_ARTIKELEN || printers + scanners + laptops < MIN_ARTIKELEN)
			throw new BestellingException(String.format("Bestelling moet minstens %d, maximaal %d artikelen bevatten", MIN_ARTIKELEN, MAX_ARTIKELEN));
	}

//	GETTERS - SETTERS
	private void setPrinters(int printers) {
		if (printers > MAX_PRINTERS || printers < 0)
			throw new IllegalArgumentException(String.format("Ongeldig aantal printers (MIN = 0, MAX = %d)", MAX_PRINTERS));
		this.printers = printers;
	}

	private void setScanners(int scanners ) {
		if (scanners> MAX_SCANNERS || scanners < 0)
			throw new IllegalArgumentException(String.format("Ongeldig aantal scanners (MIN = 0, MAX = %d)", MAX_SCANNERS));
		this.scanners = scanners;
	}

	private void setLaptops(int laptops) {
		if (laptops > MAX_LAPTOPS || laptops < 0)
			throw new IllegalArgumentException(String.format("Ongeldig aantal laptops (MIN = 0, MAX = %d)", MAX_LAPTOPS));
		this.laptops = laptops;
	}

//	PUBLIC METHODS
	public String toString() {
		return String.format("%s met %d printers, %d laptops en %d scanners.", getClass().getSimpleName(), printers,
				laptops, scanners);
	}
}
