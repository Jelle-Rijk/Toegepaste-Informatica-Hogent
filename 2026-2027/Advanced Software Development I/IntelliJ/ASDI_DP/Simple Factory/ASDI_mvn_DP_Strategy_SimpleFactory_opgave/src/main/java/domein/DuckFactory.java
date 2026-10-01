package domein;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static domein.DuckSpecies.*;

public class DuckFactory {
    private final Map<DuckSpecies, Supplier<Duck>> factory;

    public DuckFactory() {
        factory = new HashMap<>();

        FlyBehavior flyWithWings = () -> "Ik vlieg!!";
        FlyBehavior flyNoWay = () -> "Ik kan niet vliegen";
        QuackBehavior quack = () -> "Ik kwaak";
        QuackBehavior squeak = () -> "Piep";
        QuackBehavior muteQuack = () -> "<<Stilte>>";

        add(REDHEAD, () -> new Duck(quack, flyWithWings, () -> "Ik lijk op een roodkuifeend"));
        add(MALLARD, () -> new Duck(quack, flyWithWings, () -> "Ik ben een echte wilde eend"));
        add(RUBBER, () -> new Duck(squeak, flyNoWay, () -> "Ik ben een badeend"));
        add(DECOY, () -> new Duck(muteQuack, flyNoWay, () -> "Ik ben een lokeend"));
    }

    private void add(DuckSpecies species, Supplier<Duck> duckSupplier) {
        factory.put(species, duckSupplier);
    }

    public Duck createDuck(DuckSpecies type) {
        Supplier<Duck> duckSupplier = factory.get(type);
        return duckSupplier != null ? duckSupplier.get() : new NoDuck();
    }

}
