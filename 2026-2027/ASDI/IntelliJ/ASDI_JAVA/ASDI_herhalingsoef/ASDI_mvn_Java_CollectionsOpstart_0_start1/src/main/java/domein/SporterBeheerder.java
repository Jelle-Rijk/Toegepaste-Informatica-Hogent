package domein;

import java.util.*;
import java.util.stream.Collectors;

import repository.SporterDao;
import repository.SporterDaoJpa;

public class SporterBeheerder {

    private final SporterDao sporterDao;
    private final List<Sporter> sportersLijst;

    Map<Integer, Sporter> sportersPerLidnummer;
    Map<Integer, List<Sporter>> sportersPerAantalReductiebonnen;

    public SporterBeheerder() {
        sporterDao = new SporterDaoJpa();
        sportersLijst = sporterDao.findAll();
        // OEF MAP
        maakOverzichten();
    }

    public Collection<Sporter> getSportersLijst() {
        return Collections.unmodifiableCollection(sportersLijst);
    }

    public Sporter geefEenSporterMetGegevenReductiebon(Reductiebon bon) {
        return sportersLijst.stream().filter(sporter -> sporter.getReductiebonLijst().contains(bon)).findAny()
                .orElse(null);
    }

    public List<Reductiebon> geefAlleReductiebonnenMetKortingsPercentageX(List<Integer> kortingspercentage) {
        return sportersLijst.stream().map(Sporter::getReductiebonLijst).flatMap(Collection::stream)
                .filter(bon -> kortingspercentage.contains(bon.getPercentage())).collect(Collectors.toList());
    }

    public void verwijderAlleSportersMetReductiebonMetPercX(int perc) {
        sportersLijst.removeIf(s -> s.getReductiebonLijst().stream().
                anyMatch(bon -> bon.getPercentage() == perc));
    }


    // OEF MAP VRAAG 1
    public void maakOverzichten() {
        sportersPerLidnummer = sportersLijst.stream().collect(Collectors.toMap(Sporter::getLidNr, sporter -> sporter));
        sportersPerAantalReductiebonnen = sportersLijst.stream()
                .collect(Collectors.groupingBy(sporter -> sporter.getReductiebonLijst().size()));
    }

    // OEF MAP VRAAG 2.1
    public Sporter geefSporter(int sporterLidNr) {
        return sportersPerLidnummer.get(sporterLidNr);
    }

    // OEF MAP VRAAG 2.1
    public List<Sporter> geefSportersMetEvenveelReductiebonnen(Sporter sporter) {
        return sportersPerAantalReductiebonnen.get(sporter.getReductiebonLijst().size());
    }

    // OEF GENERICS VRAAG 1
    public <K extends Comparable<K>, V> String geefAlleSleutelsWaarden(Map<K, V> map) {
        return map.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(entry -> "%s:%s".formatted(entry.getKey(), entry.getValue())).collect(
                Collectors.joining("\n"));
    }

    public String geefSportersPerLidnr() {
        return geefAlleSleutelsWaarden(sportersPerLidnummer);
    }

    public String geefSportersPerAantalReductiebonnen() {
        return geefAlleSleutelsWaarden(sportersPerAantalReductiebonnen);
    }


}
