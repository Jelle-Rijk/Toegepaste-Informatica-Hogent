package domein;

import lombok.AllArgsConstructor;
import persistentie.PersistentieController;

@AllArgsConstructor
public class ContinentService {

    private PersistentieController persistentieController;
    private static final int PER_1000_INWONERS = 1000;

    public ContinentService() {
        this(new PersistentieController());
    }

    public double geefGeboorteOverschot(String continent) {
        if (continent == null || continent.isBlank()) {
            throw new IllegalArgumentException("continent moet ingevuld zijn");
        }

        long aantalInwoners = persistentieController.findAantalBewoners(continent);
        if (aantalInwoners <= 0) {
            throw new IllegalArgumentException("geen inwoners gevonden voor gegeven continent");
        }

        long aantalSterfgevallen = persistentieController.findSterfteCijfer(continent);
        long aantalGeboorten = persistentieController.findGeboortecijfers(continent);
        if (aantalSterfgevallen < 0 | aantalGeboorten < 0) {
            throw new IllegalArgumentException("De sterfte- of geboortecijfers zijn ongeldig.");
        }

        double geboortecijfer = (double) aantalGeboorten / aantalInwoners * PER_1000_INWONERS;
        double sterftecijfer = (double) aantalSterfgevallen / aantalInwoners * PER_1000_INWONERS;

        return geboortecijfer - sterftecijfer;
    }
}