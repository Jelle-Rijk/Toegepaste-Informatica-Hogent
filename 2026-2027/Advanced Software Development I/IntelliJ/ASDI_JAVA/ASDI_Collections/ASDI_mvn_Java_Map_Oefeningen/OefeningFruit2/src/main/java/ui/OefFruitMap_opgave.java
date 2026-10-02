package ui;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OefFruitMap_opgave {

    public void main() {
        String kist[][] = {{"appel", "peer", "citroen", "kiwi", "perzik"},
                {"banaan", "mango", "citroen", "kiwi", "zespri", "pruim"},
                {"peche", "lichi", "kriek", "kers", "papaya"}};

        //List<String> list =           ;
        List<String> list = Stream.of(kist).flatMap(Arrays::stream).collect(Collectors.toList());

        Scanner in = new Scanner(System.in);

        //declaratie + creatie map
        //------------------------------
        Map<String, Double> fruit = list.stream()
                .collect(Collectors.toMap(key -> key, _ -> 0.0, (fruit1, _) -> fruit1, TreeMap::new));
                            
        /*Berg de fruit list van vorige oefeningen in een boom
 op zodat dubbels ge�limineerd worden.
 Er moet ook de mogelijkheid zijn de bijhorende prijs
 (decimale waarde) bij te houden.*/
        //------------------------------------------------------------

                /*Doorloop de boom in lexicaal oplopende volgorde en vraag
         telkens de bijhorende prijs, die je mee in de boom opbergt.*/
        //------------------------------------------------------------
//        for (String key : fruit.keySet()) {
//            System.out.printf("Prijs van %s : ", key);
//            double prijs = in.nextDouble();
//            fruit.put(key, prijs);
//        }
        //Modeloplossing = functional
        fruit.entrySet().forEach(entry -> {
            System.out.printf("Prijs van %s : ", entry.getKey());
            double prijs = in.nextDouble();
            entry.setValue(prijs);
        });


        
        
        /*Druk vervolgens de volledige lijst in twee
 kolommen (naam : prijs) in lexicaal oplopende volgorde af
 op het scherm.*/
        //------------------------------------------------------------
        fruit.forEach((key, value) ->
                System.out.printf("%s\t%.2f%n", key, fruit.get(key))
        );

    }
}
