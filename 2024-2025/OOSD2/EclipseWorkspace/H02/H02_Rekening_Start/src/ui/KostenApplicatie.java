package ui;

import java.util.List;

import domein.Beheerskost;
import domein.DomeinController;
import dtos.BeheerskostDTO;

public class KostenApplicatie {
	private DomeinController dc;

	public KostenApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void werkMetKosten() {
		for (BeheerskostDTO bk : dc.geefInfoBeheersKosten()) {
			String titel = "";
			String houder = String.format("houder = %s", bk.houder());
			String kost = String.format("Kost: %.2f", bk.kost());
			String details = String.format("Details: ");
			
			switch (bk.soort()) {
			case 'z', 's': {
				titel = bk.soort() == 'z' ? "zichtrekening" : "spaarrekening";
				details += geefDetailsRekening("zichtrekening", bk);
				break;
			}
			case 'k': {
				titel = String.format("kluisnr = %d", bk.kluisnummer());
				details += String.format("%s, %s", titel, houder);
			}
			}
			System.out.printf("%n%s, %s%n%s%n%s", titel, houder, details, kost);
			System.out.println();
		}
	}

	private String geefDetailsRekening(String titel, BeheerskostDTO dto) {
		String houder = dto.houder();
		double saldo = dto.saldo();
		String rekeningNr = String.format("%012d", dto.rekeningNummer());
		String details = String.format("%s met rekeningnummer %s-%s-%s%nstaat op naam van %s%nen bevat %.2f euro.", titel,
				rekeningNr.substring(0, 2), rekeningNr.substring(3, 9), rekeningNr.substring(10), dto.houder(), dto.saldo());
		if (dto.soort() == 'z') {
			details += String.format(" Max krediet onder nul = %.2f", dto.maxKredietOnderNul());
		} else if (dto.soort() == 's') {
			details += String.format(" Aangroeiintrest = %.2f%%", dc.geefAangroeiIntrestSpaarRekening());
		}
		return details;
	}
}
