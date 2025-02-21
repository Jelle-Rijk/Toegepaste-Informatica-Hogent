package ui;

import java.util.List;

import domein.DomeinController;
import dto.DraagbaarDTO;

public class VoorwerpApp {
	DomeinController dc;

	public VoorwerpApp(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		voegVoorwerpenToe();
		toonVoorwerpen(dc.geefDataCollectie());
	}

	private void voegVoorwerpenToe() {
		dc.voegWapenToe("Colt", 1.5, 3, 6, false);
		dc.voegSleutelToe("Voordeur", 0.5, 3, 1);
		dc.voegWapenToe("Brown", 0.5, 1, 23, true);
		dc.voegSleutelToe("Achterdeur", 0.5, 1, 2);
		dc.voegGebouwToe("residentie Frankenstein", 4.5);
	};

	private void toonVoorwerpen(List<DraagbaarDTO> dtos) {
		for (DraagbaarDTO d : dtos) {
			System.out.println(toonVoorwerp(d));
		}
	}

	private String toonVoorwerp(DraagbaarDTO d) {
		String voorwerp = String.format("%s ", d.type());
		if (d.type().equals("Wapen") || d.type().equals("Sleutel")) {
			voorwerp += String.format("%s met gewicht %.3f uit niveau %d ", d.naam(),d.gewicht(), d.niveau());
			if (d.type().equals("Wapen")) {
				voorwerp += String.format("en met kracht %d %s gebruikt en", d.kracht(), d.gebruikt()? "al" : "nog niet");
			} else {
				voorwerp += String.format("past op deur %d en", d.deur());
			}
		}
		if (d.type().equals("Gebouw")) {
			voorwerp += String.format("\"%s\" met hoogte %.1f", d.naam(), d.hoogte());
		}
		voorwerp += String.format(" is %sdraagbaar.", d.draagbaar()? "" : "niet ");
		return voorwerp;
	}
}
