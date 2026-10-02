package domein;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Bier {

    private String naam, soort;
    private double alcoholgehalte, beoordeling;
    private String brouwerij;

    @Override
    public String toString() {
        return "naam = %s, soort = %s, brouwerij = %s, alcoholgehalte = %.2f, beoordeling = %.1f".
                formatted(naam, soort, brouwerij, alcoholgehalte, beoordeling);
    }

}

