package domein;

import exceptions.NegativeNumberException;

public class DomeinController {
	private MijnGetal mg;

	public void startBerekeningVierkantswortel(double getal) throws NegativeNumberException {
		mg = new MijnGetal(getal);
	}

	public double geefGetal() {
		return mg.getGetal();
	}

	public double geefVierkantswortel() {
		return mg.geefVierkantswortel();
	}

}
