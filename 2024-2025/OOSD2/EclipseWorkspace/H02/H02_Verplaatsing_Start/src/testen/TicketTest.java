package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Ticket;

public class TicketTest {

    private Ticket t;
    private static final String GELDIGE_OMSCHRIJVING = "parkeerticket";
    private static final double GELDIGE_PRIJS = 5.5;

    @BeforeEach
    public void before() 
    {
        t = new Ticket(GELDIGE_OMSCHRIJVING, GELDIGE_PRIJS);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource (strings = {" ", "\t   \n\t    \n  "})
    public void maakTicket_fouteOmschrijving_werptException(String omschr) 
    {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> new Ticket(omschr, GELDIGE_PRIJS));
    }
    
    @Test
    public void maakTicket_omschrijvingEnprijsOk_maaktObject() 
    {
        Assertions.assertEquals(GELDIGE_OMSCHRIJVING, t.getOmschrijving());
        Assertions.assertEquals(GELDIGE_PRIJS, t.getPrijs(), 0.01);
    }

    @ParameterizedTest
    @ValueSource (doubles = {-2.5, 0})
    public void maakTicket_prijsNegatieveWaarde_werptException(double prijs) 
    {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> new Ticket(GELDIGE_OMSCHRIJVING, prijs));
    }

    @Test
    public void berekenPrijs_geldigeObject_geeft5Punt5Terug() 
    {
        Assertions.assertEquals(GELDIGE_PRIJS, t.berekenPrijs(), 0.01);
    }
}