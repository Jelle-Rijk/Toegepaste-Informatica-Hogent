package domeinOpl;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class Arbeider implements Statuut {

    @NonNull private double uurloon;
    @NonNull private int ploegenstelsel;

    @Override()
    public double geefJaarInkomst() {
        return uurloon * ploegenstelsel * 12;
    }

}