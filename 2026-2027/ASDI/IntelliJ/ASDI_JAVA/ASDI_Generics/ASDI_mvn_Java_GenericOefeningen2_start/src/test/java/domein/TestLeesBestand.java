package domein;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;

class TestLeesBestand {

    private final Object[][] resultaat = {{"WestVleteren_Blond", 5.0},
    {"Tripel_Kanunnik", 8.2}, {"Black_Albert", 13.0},
    {"Rochefort_10", 11.0},
    {"Alpaïde", 9.5}, {"Cantillon_Geuze", 5.0},
    {"Moinette_Blonde", 8.5}, {"Wilderen_Goud", 6.0},
    {"Tripel_Karmeliet", 8.4}, {"Westmalle_Tripel", 9.5},};

    @SuppressWarnings("unchecked")
	private MyListIterable<Bier> leesBestand() {
        
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(new File("target/bierenListObj.dat").toPath()))) {
            return (MyListIterable<Bier>) in.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            return null;
        }
    }

    @Test
    void leesTest() {
        MyListIterable<Bier> myList = leesBestand();

        assertFalse(myList.isEmpty());

        for (int rijIndex = 0; rijIndex < resultaat.length; rijIndex++) {
            Bier bier = myList.removeFromFront();
            assertEquals((String) resultaat[rijIndex][0], bier.getBierNaam());
            assertEquals((Double) resultaat[rijIndex][1], bier.getAlcohol(), 0.0);
        }

        assertTrue(myList.isEmpty());
    }
}

