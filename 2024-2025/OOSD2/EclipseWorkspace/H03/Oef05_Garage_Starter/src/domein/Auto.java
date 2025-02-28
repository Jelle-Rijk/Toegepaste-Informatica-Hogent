package domein;

public class Auto implements Comparable<Auto> {

	private String nummerplaat;
	private String merk;
	private String model;
	private int aantalOnderhoudsbeurten;

	public Auto(String nummerplaat, String merk, String model) {
		this(nummerplaat, merk, model, 0);
	}

	public Auto(String nummerplaat, String merk, String model, int aantalOnderhoudsbeurten) {
		setNummerplaat(nummerplaat);
		setMerk(merk);
		setModel(model);
		setAantalOnderhoudsbeurten(aantalOnderhoudsbeurten);
	}

	public String getMerk() {
		return merk;
	}

	private void setMerk(String merk) {
		this.merk = merk;
	}

	public String getModel() {
		return model;
	}

	private void setModel(String model) {
		this.model = model;
	}

	public String getNummerplaat() {
		return nummerplaat;
	}

	private void setNummerplaat(String nummerplaat) {
		this.nummerplaat = nummerplaat;
	}

	public int getAantalOnderhoudsbeurten() {
		return aantalOnderhoudsbeurten;
	}

	public void setAantalOnderhoudsbeurten(int aantalOnderhoudsbeurten) {
		this.aantalOnderhoudsbeurten = aantalOnderhoudsbeurten;
	}

	public void voegOnderhoudToe() {
		this.aantalOnderhoudsbeurten++;
	}


	@Override
	public int compareTo(Auto o) {
		return nummerplaat.compareTo(o.getNummerplaat());
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Auto andereAuto = (Auto) o;
		return nummerplaat.equals(andereAuto.getNummerplaat());
	}

}
