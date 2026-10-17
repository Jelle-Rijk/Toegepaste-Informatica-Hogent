package main;

import domeinSlecht.Bediende;
import domeinSlecht.Manager;
import domeinSlecht.Werknemer;

public class StartUpSlecht {

    public void main() {
        Werknemer werknemerJan = new Bediende("Wolfs", "Jan", "3/5/1980", 2000.00);

        IO.println(werknemerJan.geefJaarInkomst());
        
        // promotie: 
        werknemerJan = new Manager("Wolfs", "Jan", "3/5/1980", 3000.00, 500.50);
        IO.println(werknemerJan.geefJaarInkomst());
    }
}
