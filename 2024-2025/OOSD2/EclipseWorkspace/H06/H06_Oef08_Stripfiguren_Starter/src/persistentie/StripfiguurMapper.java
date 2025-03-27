package persistentie;

import domein.Stripfiguur;

public class StripfiguurMapper {

	public Stripfiguur[] geefStripfiguren() {
		Stripfiguur joe = new Stripfiguur("Joe", 1.50);
		Stripfiguur jack = new Stripfiguur("Jack", 1.60);
		Stripfiguur william = new Stripfiguur("William", 1.65);
		Stripfiguur averall = new Stripfiguur("Averall", 1.90);
		Stripfiguur theDaltons[] = { joe, william, jack, averall, joe };
		return theDaltons;
	}

	public Stripfiguur[] geefExtraStripfiguren() {
		Stripfiguur ma = new Stripfiguur("Ma Dalton", 1.50);
		Stripfiguur pa = new Stripfiguur("Pa Dalton", 1.80);
		Stripfiguur oomMarcel = new Stripfiguur("Oom Marcel", 1.70);
		Stripfiguur oomHenry = new Stripfiguur("Oom Henry", 1.70);
		Stripfiguur familieLeden[] = { ma, pa, oomMarcel, oomHenry };
		return familieLeden;
	}

}
