package domein;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Categorie;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Categorie.*;

public class SnackTest {

    private static final String GELDIGENAAM = "eenSnack";

    @ParameterizedTest
    @ValueSource(strings = {GELDIGENAAM, "abc", "a bc", "  a"})
    void maakSnack_GeldigeNaam_MaaktSnack(String naam) {
        Snack s = new Snack(naam, FRUIT);
        assertEquals(naam, s.getNaam());
        assertEquals(FRUIT, s.getCategorie());
    }

    //Oef deel1: controleer de constructor met alle categorieën
    @ParameterizedTest
    @EnumSource(Categorie.class)
    void maakSnack_GeldigeCategorie_MaaktSnack(Categorie categorie) {
        Snack s = new Snack(GELDIGENAAM, categorie);
        assertEquals(GELDIGENAAM, s.getNaam());
        assertEquals(categorie, s.getCategorie());
    }

    @Test
    void ongeldigeCategorie_GooitIAE() {
        assertThrows(IllegalArgumentException.class, () -> new Snack(GELDIGENAAM, null));
    }

    //Oef deel2
    //Oplossing 1TI
	/*@Test
	void isGezond_GezondeSnack_RetourneertTrue() {
		assertTrue(new Snack("Wortel", GROENTE).isGezond());
		assertTrue(new Snack("Appel", FRUIT).isGezond());
	}

	@Test
	void isGezond_OngezondeSnack_RetourneertFalse() {
		assertFalse(new Snack("M&M", SNOEP).isGezond());
		assertFalse(new Snack("Bicky", HAMBURGER).isGezond());
	}*/

    //Oplossing1 deel2
    @ParameterizedTest
    @EnumSource(value = Categorie.class, names = {"GROENTE", "FRUIT"})
    void isGezond_GezondeSnack_RetourneertTrue_EnumSource(Categorie categorie) {
        assertTrue(new Snack(GELDIGENAAM, categorie).isGezond());
    }

    @ParameterizedTest
    @EnumSource(value = Categorie.class, names = {"SNOEP", "HAMBURGER"})
    void isGezond_OngezondeSnack_RetourneertFalse_EnumSource(Categorie categorie) {
        assertFalse(new Snack(GELDIGENAAM, categorie).isGezond());
    }

//    Oplossing2 deel2

//    EERSTE EIGEN UITWERKING
//    static private Stream<Categorie> geefOngezondeCategorieën() {
//        return Stream.of(SNOEP, HAMBURGER);
//    }
//    static private Stream<Categorie> geefGezondeCategorieën() {
//        return Stream.of(GROENTE, FRUIT);
//    }
//
//    @ParameterizedTest
//    @MethodSource("geefGezondeCategorieën")
//    void isGezond_GezondeSnack_RetourneertTrue_MethodSource(Categorie categorie) {
//        assertTrue(new Snack(GELDIGENAAM, categorie).isGezond());
//    }
//
//    @ParameterizedTest
//    @MethodSource("geefOngezondeCategorieën")
//    void isGezond_OngezondeSnack_RetourneertFalse_MethodSource(Categorie categorie) {
//        assertFalse(new Snack(GELDIGENAAM, categorie).isGezond());
//    }

    //    BETER:
    private static Stream<Arguments> opsommingSnacksVoorIsGezond() {
        return Stream.of(
                Arguments.of(GROENTE, true),
                Arguments.of(FRUIT, true),
                Arguments.of(SNOEP, false),
                Arguments.of(HAMBURGER, false)
        );
    }

    @ParameterizedTest
    @MethodSource("opsommingSnacksVoorIsGezond")
    void isGezond_RetourneertVerwachtResultaat(Categorie categorie, boolean verwachtResultaat) {
        assertEquals(verwachtResultaat, new Snack(GELDIGENAAM, categorie).isGezond());
    }
}
