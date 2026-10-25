package domeinOpl;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class Bediende implements Statuut {

	@NonNull private double maandwedde;

	@Override()
	public double geefJaarInkomst() {
		return maandwedde * 12;
	}

}