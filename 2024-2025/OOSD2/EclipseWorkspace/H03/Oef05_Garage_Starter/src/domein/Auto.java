package domein;

public class Auto {

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

}
