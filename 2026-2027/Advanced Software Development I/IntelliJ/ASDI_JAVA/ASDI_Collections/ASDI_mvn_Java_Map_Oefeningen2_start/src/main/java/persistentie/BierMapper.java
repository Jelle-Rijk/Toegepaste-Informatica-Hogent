package persistentie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import domein.Bier;

public class BierMapper {

    public List<Bier> inlezenBieren(String naamBestand) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(naamBestand);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines().map(this::leesBier).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Bier leesBier(String regel) {
        try (Scanner scanner = new Scanner(regel)) {
            return new Bier(scanner.next(), scanner.next(), scanner.nextDouble(), scanner.nextDouble(),
                    scanner.nextLine().trim());
        }
    }
}


