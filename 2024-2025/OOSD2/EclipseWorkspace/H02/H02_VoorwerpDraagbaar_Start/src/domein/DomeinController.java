package domein;

import java.util.List;

public class DomeinController {
	private DraagbaarRepository draagbaarRepo;

	public DomeinController() {
		this.draagbaarRepo = new DraagbaarRepository();
	}
	
	public void voegWapenToe(String naam, double gewicht, int niveau, int kracht, boolean gebruikt) {
		
	}
	
	public void voegWapenToe(String naam, double gewicht, int niveau, int deur) {
		
	}
	
	public void voegGebouwToe(String naam, double hoogte) {
		
	}
	
	public int geefAantalSleutelsInOmloop() {
		return 0;
	}
	
	public List<DraagbaarDTO> geefDataCollectie(){
		
		return null;
	}
}
