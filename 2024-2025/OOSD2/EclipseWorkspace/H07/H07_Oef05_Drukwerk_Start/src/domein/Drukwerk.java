package domein;

public class Drukwerk implements Werk{

	private String info;
	private long oplage;
	private double prijs;

	public Drukwerk(String info, long oplage, double prijs) {
		setInfo(info);
		setOplage(oplage);
		setPrijs(prijs);
	}

	public String getInfo() {
		return info;
	}

    private void setInfo(String info) {
		if (info == null || info.isBlank() )
			throw new IllegalArgumentException("Geen correcte info!");
		this.info = info;
	}

	public long getOplage() {
		return oplage;
	}

	private void setOplage(long oplage) {
		if (oplage <= 0)
			throw new IllegalArgumentException("Verkeerde oplage!");
		this.oplage = oplage;
	}

	public double getPrijs() {
		return prijs;
	}

	private void setPrijs(double prijs) { 
		if (prijs < GEEN_PRIJS)
			throw new IllegalArgumentException("Prijs kan niet negatief zijn.");
		this.prijs = prijs;
	}

	@Override
	public String toString() {
		String res = String.format("%s %d", info, oplage);
		if (prijs == GEEN_PRIJS)
			res += " prijs nog niet meegedeeld";
		else
			res += String.format(" %.2f", prijs);
		return res;
	}

	@Override
	public int geefPublicatiejaar() 
	{
		return Integer.parseInt(info.substring(info.length() - 4));
	}

	/** TODO - 2 Drukwerk-objecten zijn dezelfde als hun waarden van al hun attributen dezelfde zijn */
	
	
	
	

}