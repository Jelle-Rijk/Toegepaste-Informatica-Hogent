package domein;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vervoermiddel implements TebetalenTaks, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "IndexSequence")
    @TableGenerator(name="VervoerSequence", table = "IndexSequence", pkColumnName = "Nummering", valueColumnName = "HoogsteIndex", pkColumnValue = "Vervoermiddel_id")
    private long id;
	
	@Getter @Setter private String nummerplaat;

    @OneToMany
    private final List<Onderhoudsbeurt> onderhoudsbeurten = new ArrayList<>();

    public Vervoermiddel(String nummerplaat) {
        this.nummerplaat = nummerplaat;
    }
    
    public List<Onderhoudsbeurt> getOnderhoudsbeurten() {
        //TODO
        return null;
    }
    
    public void addOnderhoudsbeurt(Onderhoudsbeurt ob){
        onderhoudsbeurten.add(ob);
    }

    @Override
    public String toString() {
        return "Vervoermiddel{nummerplaat=%s}%n".formatted(nummerplaat);
    }

}
