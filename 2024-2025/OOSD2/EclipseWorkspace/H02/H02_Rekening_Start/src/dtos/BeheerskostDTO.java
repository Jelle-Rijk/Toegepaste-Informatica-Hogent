package dtos;

import domein.Beheerskost;
import domein.Kluis;
import domein.SpaarRekening;
import domein.ZichtRekening;

public record BeheerskostDTO(char soort, String houder, int kluisnummer, long rekeningNummer, double saldo, double maxKredietOnderNul, double kost) {

	public static BeheerskostDTO maakBeheerskostDTO(Beheerskost bk) {
		if (bk instanceof Kluis k)
			return new BeheerskostDTO('k', k.getHouder(), k.getKluisnummer(), 0, 0, 0, bk.geefJaarlijkseKost());
		else if (bk instanceof ZichtRekening zr)
			return new BeheerskostDTO('z', zr.getHouder(), 0, zr.getRekeningNr(), zr.getSaldo(), zr.getMaxKredietOnderNul(), bk.geefJaarlijkseKost());
		else if (bk instanceof SpaarRekening sr)
			return new BeheerskostDTO('s', sr.getHouder(), 0, sr.getRekeningNr(), sr.getSaldo(), 0, bk.geefJaarlijkseKost());
		throw new IllegalArgumentException("Kan geen BeheerskostDTO maken van een object dat geen Beheerskost implementeert.");
	}
}
