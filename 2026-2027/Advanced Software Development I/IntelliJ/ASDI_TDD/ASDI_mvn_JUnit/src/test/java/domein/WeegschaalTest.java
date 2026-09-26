package domein;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class WeegschaalTest {

    private Weegschaal weegschaal;

    @BeforeEach
    void setUp() {
        weegschaal = new Weegschaal();
    }

    @Test
    void gewichtVermeerderen() {
        BigInteger gewicht = new BigInteger("15");
        Weegschaal weegschaal = new Weegschaal();
        weegschaal.vermeerder(gewicht);
        assertEquals(gewicht, weegschaal.getGewicht());
    }

    @Test
    void nieuweWeegschaalGeeftGewichtNul() {
        Weegschaal weegschaal = new Weegschaal();
        assertEquals(BigInteger.ZERO, weegschaal.getGewicht());
    }

/*
    @Test
    void gewichtVermeerderenMetNegatieveWaarde() {
        BigInteger gewicht = new BigInteger("-20");
        assertThrows(IllegalArgumentException.class, () ->
            weegschaal.vermeerder(gewicht));
    }

    @Test
    void gewichtVermeerderenMetNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            weegschaal.vermeerder(null);
        });
    }
*/

}