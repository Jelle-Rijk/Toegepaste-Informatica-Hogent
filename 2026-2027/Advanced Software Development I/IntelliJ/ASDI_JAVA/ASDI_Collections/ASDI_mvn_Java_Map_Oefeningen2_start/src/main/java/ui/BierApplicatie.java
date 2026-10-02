package ui;

import domein.DomeinController;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BierApplicatie {

    private DomeinController domeinController;

    public void run() {
    	IO.println(domeinController.opzettenBierPerNaam());
        IO.println();
        IO.println(domeinController.opzettenAantalBierenPerSoort());
        IO.println();
        IO.println(domeinController.opzettenOverzichtBierenPerSoort());
    }
}
