package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Drukwerk;
import domein.Werk;

public class DrukwerkMapper {

	public List<Drukwerk> initDrukwerkData() {
        List<Drukwerk> lijst = new ArrayList<>();
        lijst.add(new Drukwerk("Fictie_1999",12300,13.99));
        lijst.add(new Drukwerk("Biografie_1999",4000, Werk.GEEN_PRIJS));
        lijst.add(new Drukwerk("Geschiedenis_2010",5000,Werk.GEEN_PRIJS));
        lijst.add(new Drukwerk("Politiek_2010",5460,18.99));
        lijst.add(new Drukwerk("Autobiografie_2020",6500, 14.95));
        lijst.add(new Drukwerk("Biografie_2020",3000,Werk.GEEN_PRIJS));
        return lijst;
	}
	
	//nieuwe releases
	public Drukwerk[] geefNieuweReleases()
	{
		Drukwerk[] nieuw = new Drukwerk[5];
		nieuw[0] = new Drukwerk("La maison Victor_2021", 25000, 13.5);
		nieuw[1] = new Drukwerk("Biografie_1999",4000, Werk.GEEN_PRIJS);
		nieuw[2] = new Drukwerk("Humo_2021", 25000, 3.5);
		nieuw[3] = new Drukwerk("Flair_2021", 25500, 3.5);
		nieuw[4] = new Drukwerk("Dag Allemaal_2021", 25000, 4.5);
		return nieuw;
	}
}
