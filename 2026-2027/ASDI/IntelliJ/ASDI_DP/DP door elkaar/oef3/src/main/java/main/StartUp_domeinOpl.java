package main;

import domeinOpl.*;

public class StartUp_domeinOpl {

    public void main() {

        //werknemer is Wolfs Jan, geboren op 3/5/1980, statuut = bediende, maandwedde = 2000.00
        Werknemer werknemerJan = new Werknemer(new Bediende(2000), "Jan", "Wolfs", "3/5/1980");
        IO.println(werknemerJan.geefJaarInkomst());

        // promotie: manager, maandwedde = 3000.00 en premie = 500.50
        werknemerJan.setStatuut(new Manager(3000, 500.50));
        IO.println(werknemerJan.geefJaarInkomst());

    }
}
