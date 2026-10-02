package domein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode(of = "lidNr")
public class Sporter {

	private int lidNr;
	private String naam, voornaam;
	@Setter private String email;
	private List<Reductiebon> reductiebonLijst;

	public Sporter(int lidNr, String naam, String voornaam, String email) {
		this.lidNr = lidNr;
		this.naam = naam;
		this.voornaam = voornaam;
		setEmail(email);
		reductiebonLijst = new ArrayList<>();
	}

	public List<Reductiebon> getReductiebonLijst()
	{
		return Collections.unmodifiableList(reductiebonLijst);
	}
	
	@Override
	public String toString() {
		return "sporter %d, %s %s heeft %d reductiebon(nen)".formatted( lidNr, naam, voornaam,
				reductiebonLijst.size());
	}

	public void voegReductieBonToe(Reductiebon reductieBon) {
		reductiebonLijst.add(reductieBon);
	}
}
