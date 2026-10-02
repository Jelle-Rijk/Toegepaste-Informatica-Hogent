package domein;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class Duck {
    private QuackBehavior quackBehavior;
    private FlyBehavior flyBehavior;
    private DisplayBehavior displayBehavior;

    public String performQuack() {
        return quackBehavior.quack();
    }

    public String performFly() {
        return flyBehavior.fly();
    }

    public String swim() {
        return ("Alle eenden drijven, ook lokeenden");
    }

    public String display() {
        return displayBehavior.display();
    }

    public void ANDERE_eend_achtige_methoden() {
    }

}
