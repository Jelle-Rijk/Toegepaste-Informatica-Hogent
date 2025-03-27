package persistentie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import domein.Auto;
import domein.Onderhoud;

public class OnderhoudMapper {

	public Collection<Onderhoud> geefOnderhoudVanAutos() {
		List<Auto> autos = new ArrayList<>(new AutoMapper().geefAutos());
		List<Onderhoud> onderhoudLijst = new ArrayList<>();

		LocalDate begindatum = LocalDate.of(2021, 12, 12);
		LocalDate einddatum = LocalDate.of(2021, 12, 15);
		Onderhoud onderhoud = new Onderhoud(begindatum, einddatum, autos.get(7));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2022, 1, 11);
		einddatum = LocalDate.of(2022, 1, 11);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(6));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2022, 12, 15);
		einddatum = LocalDate.of(2022, 12, 15);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(6));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2022, 1, 11);
		einddatum = LocalDate.of(2022, 1, 12);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(4));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2021, 11, 16);
		einddatum = LocalDate.of(2021, 11, 16);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(7));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2022, 1, 15);
		einddatum = LocalDate.of(2022, 1, 15);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(6));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2021, 12, 17);
		einddatum = LocalDate.of(2021, 12, 19);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(1));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2022, 1, 10);
		einddatum = LocalDate.of(2022, 1, 10);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(4));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2021, 12, 8);
		einddatum = LocalDate.of(2021, 12, 8);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(7));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2022, 1, 17);
		einddatum = LocalDate.of(2022, 1, 17);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(6));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2021, 12, 10);
		einddatum = LocalDate.of(2021, 12, 11);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(0));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2021, 12, 15);
		einddatum = LocalDate.of(2021, 12, 16);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(0));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2021, 12, 15);
		einddatum = LocalDate.of(2021, 12, 16);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(2));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2022, 2, 15);
		einddatum = LocalDate.of(2022, 2, 15);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(5));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2022, 1, 5);
		einddatum = LocalDate.of(2022, 1, 7);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(4));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2021, 12, 17);
		einddatum = LocalDate.of(2021, 12, 19);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(0));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2021, 12, 18);
		einddatum = LocalDate.of(2021, 12, 18);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(2));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2021, 12, 17);
		einddatum = LocalDate.of(2021, 12, 17);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(2));
		onderhoudLijst.add(onderhoud);

		begindatum = LocalDate.of(2021, 12, 19);
		einddatum = LocalDate.of(2021, 12, 22);
		onderhoud = new Onderhoud(begindatum, einddatum, autos.get(2));
		onderhoudLijst.add(onderhoud);

		return onderhoudLijst;
	}
}
