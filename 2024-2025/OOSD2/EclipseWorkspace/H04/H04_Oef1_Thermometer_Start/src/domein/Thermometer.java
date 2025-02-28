package domein;

public class Thermometer
{
    private int aantalGraden;

    public Thermometer()
    {
        setAantalGraden(32);
    }
    
    public int getAantalGraden()
    {
        return aantalGraden;
    }

    public void setAantalGraden(int aantalGraden)
    {
        this.aantalGraden = aantalGraden;
    }
    
    public int converteerNaarCelsius()
    {
        return (aantalGraden - 32) * 5 / 9;
    }
}
