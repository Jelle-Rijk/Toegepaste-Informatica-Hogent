
package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domein.Movie;
import domein.YearComparator;

public class ComparableApp {

	public void startSortMovies() {
		List<Movie> allMovies = new ArrayList<Movie>();
		allMovies.add(new Movie("Force Awakens", 8.3, 2015));
		allMovies.add(new Movie("Force Awakens", 8.3, 2010));
		allMovies.add(new Movie("Force Awakens", 8.3, 2000));
		allMovies.add(new Movie("Star Wars", 8.7, 1977));
		allMovies.add(new Movie("Empire Strikes Back", 8.8, 1980));
		allMovies.add(new Movie("Return of the Jedi", 8.4, 1983));
		allMovies.add(new Movie("Return of the Jedi", 8.4, 1999));
		allMovies.add(new Movie("Return of the Jedi", 8.4, 2015));

		Collections.sort(allMovies);
		showMovies("Movies with natural ordering (name - year)", allMovies);
		Collections.sort(allMovies, new YearComparator());
		showMovies("Movies with total ordering based on year", allMovies);

		/*
		 * // ANONYMOUS INNER CLASS
		 * 
		 * Comparator<Movie> ratingComparator = new Comparator<Movie>() { public int
		 * compare(Movie m1, Movie m2) { return Double.compare(m1.getRating(),
		 * m2.getRating()) * -1; } };
		 */

		Collections.sort(allMovies, Comparator.comparing(Movie::getRating).reversed());
		showMovies("Movies with total ordering based on descending rating", allMovies);

		Collections.sort(allMovies, Comparator.comparing(Movie::getName));
		showMovies("Movies with ordering based on name", allMovies);
	}

	private void showMovies(String titel, List<Movie> allMovies) {
		System.out.printf("%s%n", titel);
		System.out.printf("%s%n", "=".repeat(titel.length()));
		for (Movie movie : allMovies) {
			System.out.println(movie);
		}
		System.out.println();
	}
}
