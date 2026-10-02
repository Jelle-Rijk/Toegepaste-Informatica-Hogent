package main;

import domein.Geweer;
import domein.Handen;
import domein.Held;
import domein.Mes;

public class StartUp
{
    public void main()
    {
        Held held = new Held();
        held.valAan();
        held.setWapen(new Geweer());
        held.valAan();
        held.setWapen(null);
        held.valAan();
        held.setWapen(new Mes());
        held.valAan();
        held.setWapen(new Handen());
        held.valAan();
    }
}

