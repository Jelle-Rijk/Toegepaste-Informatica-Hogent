package domein;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import persistentie.PersistentieController;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContinentServiceTest {
    @Mock
    private PersistentieController persistentie;
    @InjectMocks
    private ContinentService service;

    private static final String GELDIG_CONTINENT = "Europa";
    private static final long GELDIG_AANTAL_INWONERS = 123123123123132L;
    private static final long GELDIG_AANTAL_GEBOORTEN = 15654654L;
    private static final long GELDIG_AANTAL_STERFGEVALLEN = 9554654L;

    @ParameterizedTest
    @CsvSource({"16405399,184634,135136,3.01", "1,0,0,0"})
    void testGeboorteOverschot(long aantalInwoners, long aantalGeboorten, long aantalSterfgevallen,
                               double verwachteResultaat) {
        dummyTrainen(aantalInwoners, aantalGeboorten, aantalSterfgevallen);
        controleGeboorteOverschot(verwachteResultaat);
    }

    private static Stream<Arguments> geefGeboorteOverschot_OngeldigeWaarden() {
        return Stream.of(
                Arguments.of(0L, GELDIG_AANTAL_GEBOORTEN, GELDIG_AANTAL_STERFGEVALLEN),
                Arguments.of(-1L, GELDIG_AANTAL_GEBOORTEN, GELDIG_AANTAL_STERFGEVALLEN),
                Arguments.of(Long.MIN_VALUE, GELDIG_AANTAL_GEBOORTEN, GELDIG_AANTAL_STERFGEVALLEN),
                Arguments.of(GELDIG_AANTAL_INWONERS, -1L, GELDIG_AANTAL_STERFGEVALLEN),
                Arguments.of(GELDIG_AANTAL_INWONERS, Long.MIN_VALUE, GELDIG_AANTAL_STERFGEVALLEN),
                Arguments.of(GELDIG_AANTAL_INWONERS, GELDIG_AANTAL_GEBOORTEN, -1L),
                Arguments.of(GELDIG_AANTAL_INWONERS, GELDIG_AANTAL_GEBOORTEN, Long.MIN_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("geefGeboorteOverschot_OngeldigeWaarden")
    void testGeboorteOverschot_OngeldigAantalInwonersSterfgevallenOfGeboorten_ThrowsIAE(long aantalInwoners,
                                                                                        long aantalGeboorten,
                                                                                        long aantalSterfgevallen) {
        dummyTrainen(aantalInwoners, aantalGeboorten, aantalSterfgevallen);
        assertThrows(IllegalArgumentException.class, () -> service.geefGeboorteOverschot(GELDIG_CONTINENT));
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 564573L, Long.MAX_VALUE})
    void testGeboorteOverschot_ContinentHeeftGenoegInwoners_ThrowtNiet(long aantalInwoners) {
        dummyTrainen(aantalInwoners, GELDIG_AANTAL_GEBOORTEN, GELDIG_AANTAL_STERFGEVALLEN);
        assertDoesNotThrow(() -> service.geefGeboorteOverschot(GELDIG_CONTINENT));
    }

    @Test
    void testSterfteOverschot() {
        dummyTrainen(18506500L, 277597L, 333117L);
        controleGeboorteOverschot(-3);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void geefGeboorteOverschot_OngeldigContinent(String continent) {
        assertThrows(IllegalArgumentException.class, () -> service.geefGeboorteOverschot(continent));
    }

    private void dummyTrainen(long aantalInwoners, long aantalGeboorten, long aantalSterfgevallen) {
        when(persistentie.findAantalBewoners(any())).thenReturn(aantalInwoners);
        lenient().when(persistentie.findGeboortecijfers(any())).thenReturn(aantalGeboorten);
        lenient().when(persistentie.findSterfteCijfer(any())).thenReturn(aantalSterfgevallen);
    }

    private void controleGeboorteOverschot(double verwachteResultaat) {
        assertEquals(verwachteResultaat, service.geefGeboorteOverschot(GELDIG_CONTINENT), 0.01);
        verify(persistentie).findAantalBewoners(GELDIG_CONTINENT);
        verify(persistentie).findGeboortecijfers(GELDIG_CONTINENT);
        verify(persistentie).findSterfteCijfer(GELDIG_CONTINENT);
    }
}












