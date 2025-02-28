package domein;

public class MijnGetal
{
    private double getal;

    public MijnGetal(double getal) 
    {
        setGetal(getal);
    }
    
    private void setGetal(double getal) 
    {
        this.getal = getal;
    }
    
    public double getGetal()
    {
        return getal;
    }
    
    public double geefVierkantswortel()
    {
        return Math.sqrt(getal);
    }
}
