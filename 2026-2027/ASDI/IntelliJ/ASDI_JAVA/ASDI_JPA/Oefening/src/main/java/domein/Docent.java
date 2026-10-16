package domein;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of="docentNr")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Docent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(AccessLevel.NONE)
    private long id;

    @Column(name="PERSONEELSNR")
    private int docentNr;
    private String voornaam;
    private String familienaam;

    @ManyToMany
    private final Set<Campus> campussen = new HashSet<>();

    @ManyToOne
    private Werkruimte werkruimte;

    @Setter private BigDecimal wedde;

    public Docent(int docentNr, String voornaam, String familienaam, BigDecimal wedde) {
        this.docentNr = docentNr;
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.wedde = wedde;
    }

    public void opslag(BigDecimal bedrag) {
        wedde = wedde.add(bedrag);
    }

    @Override
    public String toString() {
        return "%d %s %s %s %s".formatted(
                docentNr, voornaam, familienaam, wedde, werkruimte);
    }

    public void addCampus(Campus campus) {
        campussen.add(campus);
    }

    public void removeCampus(Campus campus) {
        campussen.remove(campus);
    }

    public Set<Campus> getCampussen(){
        return null;//TODO
    }


}
=======
public class Docent {
}
>>>>>>> c39e1c38c8c5d60ff0be1122d8d3f5413ca87126
