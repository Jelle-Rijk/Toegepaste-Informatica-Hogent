package domeinSlecht;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public  abstract class Werknemer {
    
    private final String voornaam;
    private final String familienaam;
    private final String geboorteDatum;
    
    public abstract double geefJaarInkomst();
}