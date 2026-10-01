package domein;

import static domein.DuckSpecies.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DuckTest {

    private final static String FLY_NO_WAY = "Ik kan niet vliegen";
    private final static String FLY_WITH_WINGS = "Ik vlieg!!";
    private final static String QUACK = "Ik kwaak";
    private final static String SQUEAK = "Piep";
    private final static String MUTE_QUACK = "<<Stilte>>";

    private final String flyRocketPowered = "Ik vlieg met raketaandrijving";
    private DuckFactory duckFactory;

    @BeforeEach
    void setUp() {
        duckFactory = new DuckFactory();
    }

    private static Stream<Arguments> duckProvider() {
        return Stream.of(Arguments.of(MALLARD, "Ik ben een echte wilde eend", QUACK, FLY_WITH_WINGS),
                Arguments.of(RUBBER, "Ik ben een badeend", SQUEAK, FLY_NO_WAY),
                Arguments.of(REDHEAD, "Ik lijk op een roodkuifeend", QUACK, FLY_WITH_WINGS),
                Arguments.of(DECOY, "Ik ben een lokeend", MUTE_QUACK, FLY_NO_WAY));
    }


    @ParameterizedTest
    @MethodSource("duckProvider")
    void testCreateDuck(DuckSpecies kind, String expectedDisplay, String expectedQuack, String expectedFly) {
        Duck duck = duckFactory.createDuck(kind);
        assertEquals(expectedDisplay, duck.display());
        assertEquals(expectedQuack, duck.performQuack());
        assertEquals(expectedFly, duck.performFly());
    }

    @ParameterizedTest
    @MethodSource("duckProvider")
    void changeFlyingBehaviorAtRuntime(DuckSpecies kind) {
        Duck duck = duckFactory.createDuck(kind);
        duck.setFlyBehavior(() -> flyRocketPowered);
        assertEquals(flyRocketPowered, duck.performFly());
    }




}
