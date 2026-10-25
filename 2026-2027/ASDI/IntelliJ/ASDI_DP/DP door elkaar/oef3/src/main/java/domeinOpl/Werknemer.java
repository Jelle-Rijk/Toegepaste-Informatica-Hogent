package domeinOpl;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class Werknemer {

    @Setter
    private Statuut statuut;
    private final String voornaam;
    private final String familienaam;
    private final String geboorteDatum;

    public double geefJaarInkomst() {
        return statuut.geefJaarInkomst();
    }
}