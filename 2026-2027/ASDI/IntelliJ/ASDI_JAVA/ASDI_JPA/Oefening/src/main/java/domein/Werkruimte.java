package domein;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Werkruimte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(AccessLevel.NONE)
    private long id;

    private String lokaalcode;

    private String naam;
    private int aantalStoelen;
    private int aantalComputers;

    public Werkruimte(String lokaalcode, String naam, int aantalStoelen, int aantalComputers) {
        this.lokaalcode = lokaalcode;
        this.naam = naam;
        this.aantalStoelen = aantalStoelen;
        this.aantalComputers = aantalComputers;
    }

    @Override
    public String toString() {
        return "%s %s %d %d".formatted(lokaalcode, naam, aantalStoelen, aantalComputers);
    }

}
=======
public class Werkruimte {
}
>>>>>>> c39e1c38c8c5d60ff0be1122d8d3f5413ca87126
