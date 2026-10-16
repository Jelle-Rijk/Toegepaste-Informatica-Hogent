package domein;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(AccessLevel.NONE)
    private long id;

    private int campusID;

    @Getter @Setter private String campusNaam;

    @ManyToMany
    private final Set<Docent> docenten = new HashSet<>();

    public Campus(String campusNaam) {
        this.campusNaam = campusNaam;
    }

    public Set<Docent> getDocenten() {
        return docenten;
    }

    public void addDocent(Docent docent) {
        docenten.add(docent);
    }

    public void removeDocent(Docent docent) {
        docenten.remove(docent);
    }

    @Override
    public String toString() {
        return "%d %s".formatted(campusID, campusNaam);
    }

}
