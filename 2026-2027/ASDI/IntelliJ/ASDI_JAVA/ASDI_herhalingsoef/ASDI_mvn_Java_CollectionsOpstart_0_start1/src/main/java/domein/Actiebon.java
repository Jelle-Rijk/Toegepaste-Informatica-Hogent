package domein;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Actiebon extends Reductiebon {
	private String beschrijving;

	public Actiebon(String beschrijving, String reductiebonCode, int percentage, LocalDate einddatum) {
		super(reductiebonCode, percentage, einddatum);
	}
	
}
