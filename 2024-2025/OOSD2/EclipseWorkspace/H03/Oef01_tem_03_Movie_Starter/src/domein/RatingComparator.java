package domein;

import java.util.Comparator;

public class RatingComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie m1, Movie m2) {
		return Double.compare(m1.getRating(), m2.getRating()) * -1;
	}

}
