package ui;

import java.util.*;
import java.util.stream.Collectors;

class CollectionOperaties {

    //methode verwijderOpLetter
    //-------------------------
    static void verwijderOpLetter(List<String> lijst, char letter) {
        lijst.removeIf(woord -> woord.charAt(0) == letter);
    }

    //methode verwijderSequence
    //-------------------------
    static void verwijderSequence(List<String> lijst, String delimiter) {
        int eersteDelimiter = lijst.indexOf(delimiter);
        if (eersteDelimiter == -1)
            return;
        int laatsteDelimiter = lijst.lastIndexOf(delimiter);
        lijst.subList(eersteDelimiter, laatsteDelimiter + 1).clear();
    }

    //uitbreiding opgave Fruit   addOrdered
    //-------------------------------------
    static void addOrdered(List<String> lijst, String fruit) {
//        Werkt, maar niet efficiënt
//        lijst.add(fruit);
//        Collections.sort(lijst);

//        Modeloplossing
        int index = Collections.binarySearch(lijst, fruit);
        if (index >= 0) // fruit zit al in de lijst, doe niets
            return;
        // fruit zit nog niet in de lijst, index = -(insertion point) - 1
        lijst.add(index * - 1 - 1, fruit);
    }

}

public class OefFruit_opgave {

    public void main() {
        String kist[][] = {{"appel", "peer", "citroen", "kiwi", "perzik"},
                {"banaan", "mango", "citroen", "kiwi", "zespri", "pruim"},
                {"peche", "lichi", "kriek", "kers", "papaya"}};

        List<String> list;
        String mand[];

//Toon de inhoud van de array "kist"
//----------------------------------
        IO.println(kist);

//Voeg de verschillende kisten samen in een ArrayList list.
//--------------------------------------------------------
        list = Arrays.stream(kist).flatMap(Arrays::stream).collect(Collectors.toCollection(ArrayList::new));


        CollectionOperaties.verwijderOpLetter(list, 'p');
        IO.println("na verwijder letter ('p') :  " + list + "\n");

        CollectionOperaties.verwijderSequence(list, "kiwi");
        IO.println("na verwijder sequence (kiwi) : " + list + "\n");

        //DEEL2
        CollectionOperaties.addOrdered(list, "sapodilla");


//Plaats het resultaat terug in een array mand en sorteer die oplopend.
//---------------------------------------------------------------------
        mand = list.stream().sorted().toArray(String[]::new);

//Toon de inhoud van de array "mand"
//----------------------------------
        IO.println(Arrays.toString(mand));


    }
}
