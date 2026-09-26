package domein;

import utils.Gordel;
import static utils.Gordel.*;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Judo {

	private Gordel gordel;

	public boolean isBeginner() {
		return gordel.ordinal() >= WIT.ordinal() && gordel.ordinal() <= ORANJE.ordinal();
	}
}