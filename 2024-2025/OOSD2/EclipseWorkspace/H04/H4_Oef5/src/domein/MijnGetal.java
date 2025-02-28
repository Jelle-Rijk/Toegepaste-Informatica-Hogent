package domein;

import exceptions.NegativeNumberException;

public class MijnGetal {
	private double getal;
	
//	CONSTRUCTOR
	public MijnGetal(double getal) throws NegativeNumberException {
		setGetal(getal);
	}

//	GETTERS - SETTERS
	public double getGetal() {
		return getal;
	}

	private void setGetal(double getal) throws NegativeNumberException {
		if (getal < 0) {
			throw new NegativeNumberException();
		}
		this.getal = getal;
	}
	
//	PUBLIC METHODS
	public double geefVierkantswortel() {
		return Math.sqrt(getal);
	}
	
	
}
