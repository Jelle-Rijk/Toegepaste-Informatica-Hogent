package domein;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NamedQuery(name = "Auto.getAllMetOnderhoudsbeurten", query = "select distinct a from Auto a where a.onderhoudsbeurten is empty ")
@NamedQuery(name = "Auto.getAllZonderOnderhoudsbeurten", query = "select a from Auto a where a.onderhoudsbeurten is not empty ")
@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Auto extends Vervoermiddel {

    public Auto(String nummerplaat) {
        super(nummerplaat);
    }

    @Override
    public double geefVerkeersbelasting() {
        return 77.75;
        //volgens cilinderinhoud
    }
}
