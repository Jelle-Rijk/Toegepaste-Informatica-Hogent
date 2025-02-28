package domein;


public class DomeinController
{
	private MijnGetal mg;
	
	public void startBerekeningVierkantswortel(double getal) 
	{
		mg = new MijnGetal(getal);
	}

	public double geefGetal()
	{
		return mg.getGetal();
	}

	public double geefVierkantswortel()
	{
		return mg.geefVierkantswortel();
	}
}
