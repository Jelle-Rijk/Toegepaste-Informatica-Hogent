package dto;

import domein.Draagbaar;
import domein.Gebouw;
import domein.Sleutel;
import domein.Wapen;

public record DraagbaarDTO(String naam, double gewicht, int niveau, int kracht, boolean gebruikt, int deur, double hoogte, boolean draagbaar, String type) {

	public static DraagbaarDTO maakDraagbaarDTO(Draagbaar d){
		if (d instanceof Wapen w) {
			return new DraagbaarDTO(w.getNaam(), w.getGewicht(), w.getNiveau(), w.getKracht(), w.isGebruikt(), 0, 0, w.isDraagbaar(), w.getClass().getSimpleName());
		}	
		if (d instanceof Sleutel s) {
			return new DraagbaarDTO(s.getNaam(), s.getGewicht(), s.getNiveau(), 0, false, s.getDeur(), 0, s.isDraagbaar(), s.getClass().getSimpleName());
		}
		if (d instanceof Gebouw g) {
			return new DraagbaarDTO(g.getNaam(), 0f, 0, 0, false, 0, g.getHoogte(), g.isDraagbaar(), g.getClass().getSimpleName());
		}
		throw new IllegalArgumentException("Ongeldig Draagbaar object");
	}
}
