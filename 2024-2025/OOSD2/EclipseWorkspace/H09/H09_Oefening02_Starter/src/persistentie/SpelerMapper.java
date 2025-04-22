package persistentie;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

import domein.Speler;

public class SpelerMapper {

	public void serialiseerObjectPerObject(Collection<Speler> spelerslijst, String naamBestand) {
		try (ObjectOutputStream output = new ObjectOutputStream(
				Files.newOutputStream(Path.of("src","bestanden", naamBestand)))) {
			for (Speler speler : spelerslijst)
				output.writeObject(speler);
		} catch (IOException e) {
			System.err.println("IOException boys");
			e.printStackTrace();
		}
		;
	}

	public void serialiseerVolledigeLijst(Collection<Speler> spelerslijst, String naamBestand) {
		try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Path.of("src", "bestanden", naamBestand)))) {
			output.writeObject(spelerslijst);
		} catch (IOException e) {
			System.err.println("2b IOException");
		}
	}

	public Collection<Speler> deSerialiseerObjectPerObject(String naamBestand) {
		return null;
	}

	public Collection<Speler> deSerialiseerVolledigeLijst(String naamBestand) {
		return null;
	}

	public void schrijfNaarTekstBestand(Collection<Speler> spelerslijst, String naamBestand) {
		
	}

	public Collection<Speler> leesTekstBestand(String naamBestand) {
		return null;
	}

}
