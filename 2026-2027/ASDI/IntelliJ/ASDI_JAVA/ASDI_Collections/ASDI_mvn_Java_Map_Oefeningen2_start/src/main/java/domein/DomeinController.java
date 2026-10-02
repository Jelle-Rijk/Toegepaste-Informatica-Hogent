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
        // Eigen oplossing
//        StringBuilder sb = new StringBuilder();
//        bierWinkel.opzettenOverzichtBierPerNaam().forEach((key, value) -> sb.append("%s = %s%n".formatted(key,
//        value)));
//        return sb.toString();

        // Modeloplossing
        return bierWinkel.opzettenOverzichtBierPerNaam().entrySet().stream().
                map(e -> "%s = %s".formatted(e.getKey(), e.getValue())).
                collect(Collectors.joining("\n"));
    }

    public String opzettenAantalBierenPerSoort() {
        // Eigen oplossing
//        StringBuilder sb = new StringBuilder();
//        bierWinkel.opzettenAantalBierenPerSoort().forEach((key, value) -> sb.append("%s = %d%n".formatted(key,
//        value)));
//        return sb.toString();
        return bierWinkel.opzettenAantalBierenPerSoort().entrySet().stream().
                map(e -> "%s = %s".formatted(e.getKey(), e.getValue())).
                collect(Collectors.joining("\n"));
    }

    public String opzettenOverzichtBierenPerSoort() {
        // Eigen oplossing
//        StringBuilder sb = new StringBuilder();
//        bierWinkel.opzettenOverzichtBierenPerSoort()
//                .forEach((key, value) -> sb.append("%s = %s%n".formatted(key, value)));
//        return sb.toString();
        return bierWinkel.opzettenOverzichtBierenPerSoort().entrySet().stream().
                map(e -> "%s = %s".formatted( e.getKey(),e.getValue())).
                collect(Collectors.joining("\n"));
    }


    //TODO na hoofdstuk generics 
    //--> generieke oplossing "overzichtToString" methode
    //


}
