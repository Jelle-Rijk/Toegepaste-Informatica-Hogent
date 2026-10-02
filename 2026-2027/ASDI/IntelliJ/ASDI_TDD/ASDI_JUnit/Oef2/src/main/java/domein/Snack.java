package domein;

import static utils.Categorie.*;

import lombok.Getter;
import utils.Categorie;

@Getter
public class Snack {
	private Categorie categorie;
	private String naam;

	public Snack(String naam, Categorie categorie) {
		setNaam(naam);
		setCategorie(categorie);
	}

	public boolean isGezond() {
		return categorie == FRUIT || categorie == GROENTE;
	}

	private void setNaam(String naam) {
		if (naam == null || naam.isBlank())
			throw new IllegalArgumentException("Snack moet een naam krijgen");
		this.naam = naam;
	}

	private void setCategorie(Categorie categorie) {
		if (categorie == null)
			throw new IllegalArgumentException("Snack moet een categorie krijgen");
		this.categorie = categorie;
	}

}
