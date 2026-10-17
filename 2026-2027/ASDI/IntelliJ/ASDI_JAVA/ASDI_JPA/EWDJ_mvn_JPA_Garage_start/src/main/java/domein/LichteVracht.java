package domein;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LichteVracht extends Vervoermiddel {
    
	private double massa;

    public LichteVracht(double massa, String nummerplaat) {
        super(nummerplaat);
        this.massa = massa;
    }

    @Override
    public double geefVerkeersbelasting() {
        throw new UnsupportedOperationException("Not supported yet.");
        //volgens maximale massa
    }
}
