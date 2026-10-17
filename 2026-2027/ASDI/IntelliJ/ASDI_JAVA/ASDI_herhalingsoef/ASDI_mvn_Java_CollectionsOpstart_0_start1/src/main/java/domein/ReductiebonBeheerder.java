package domein;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import repository.ReductiebonDao;
import repository.ReductiebonDaoJpa;

public class ReductiebonBeheerder {

	private final ReductiebonDao reductiebonDao;
	private final List<Reductiebon> reductiebonLijst;

	//TODO
    //private MyCollection<Reductiebon> myCollection; 

	public ReductiebonBeheerder() {
		reductiebonDao = new ReductiebonDaoJpa();
		reductiebonLijst = reductiebonDao.findAll();
		//TODO
		//myCollection = new MyCollection<>();
	}
	
	public List<Reductiebon> getReductiebonLijst() {
		return Collections.unmodifiableList(reductiebonLijst);
	}

	public List<String> geefReductiebonCodes(int percentage) {
		return reductiebonLijst.stream().filter(bon -> bon.getPercentage() > percentage)
				.map(Reductiebon::getReductiebonCode).collect(Collectors.toList());
	}

	public void sorteerReductiebonnen() {
		reductiebonLijst.sort(Comparator.comparing(Reductiebon::getPercentage)
				.thenComparing(Comparator.comparing(Reductiebon::getReductiebonCode).reversed()));
	}

	public double geefGemPercVanBonnenInToekomst()
	{
		return reductiebonLijst.stream().filter(bon -> bon.getEinddatum().isAfter(LocalDate.now())).
				mapToDouble(Reductiebon::getPercentage).average().getAsDouble();
	}

	public List<LocalDate> geefUniekeEinddatums() {
	     return reductiebonLijst.stream().
                 map(Reductiebon::getEinddatum).
                 distinct().sorted().
                 collect(Collectors.toList()); 
	}
	
	//TODO
	/*	
		public void storeBon(Reductiebon bon) {
			myCollection.addElement(bon);
		}
		
		public Reductiebon retrieveBon() {
			return myCollection.getElement();
		}
		
		// OEF GENERICS VRAAG 6
		public void addReeks   
		}
	*/
}
