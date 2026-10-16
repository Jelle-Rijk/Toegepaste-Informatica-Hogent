package domein;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DomeinController {

    private final BierWinkel bierWinkel;

    public DomeinController() {
        bierWinkel = new BierWinkel();
    }

    public String opzettenBierPerNaam() {
        // Eigen oplossing - pre-generics
//        StringBuilder sb = new StringBuilder();
//        bierWinkel.opzettenOverzichtBierPerNaam().forEach((key, value) -> sb.append("%s = %s%n".formatted(key,
//        value)));
//        return sb.toString();

        // Modeloplossing
        return overzichtToString(bierWinkel.opzettenOverzichtBierPerNaam());
    }

    public String opzettenAantalBierenPerSoort() {
        // Eigen oplossing - pre-generics
//        StringBuilder sb = new StringBuilder();
//        bierWinkel.opzettenAantalBierenPerSoort().forEach((key, value) -> sb.append("%s = %d%n".formatted(key,
//        value)));
//        return sb.toString();
        return overzichtToString(bierWinkel.opzettenAantalBierenPerSoort());
    }

    public String opzettenOverzichtBierenPerSoort() {
        // Eigen oplossing - pre-generics
//        StringBuilder sb = new StringBuilder();
//        bierWinkel.opzettenOverzichtBierenPerSoort()
//                .forEach((key, value) -> sb.append("%s = %s%n".formatted(key, value)));
//        return sb.toString();
        return overzichtToString(bierWinkel.opzettenOverzichtBierenPerSoort());

    }

    //--> generieke oplossing "overzichtToString" methode
    //
    public <K, V> String overzichtToString(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .map(e -> "%s = %s".formatted(e.getKey(), e.getValue()))
                .collect(Collectors.joining("\n"));
    }

}
