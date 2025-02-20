package dtos;

import domein.Beheerskost;

public record BeheerskostDTO(char soort, String houder, int kluisnummer, long rekeningNummer, double saldo, String houder, double maxKredietOnderNul) {

	public static maakBeheerskostDTO(Beheerskost bk) {
		
		
		new BeheerskostDTO()
	}
}
