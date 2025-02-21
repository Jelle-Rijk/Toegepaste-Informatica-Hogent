package domein;

import java.util.ArrayList;
import java.util.List;

public class DraagbaarRepository {
	private List<Draagbaar> collectie;

// CONSTRUCTOR
	public DraagbaarRepository() {
		this.collectie = new ArrayList<>();
	}

//	GETTER
	public List<Draagbaar> getCollectie() {
		return collectie;
	}

//	PUBLIC METHODS
	public void voegDraagbaarItemToe(Draagbaar item) {
		collectie.add(item);
	}
}
