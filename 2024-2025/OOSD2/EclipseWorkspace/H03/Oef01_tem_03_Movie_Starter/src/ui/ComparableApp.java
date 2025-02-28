
package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domein.Movie;
import domein.RatingComparator;
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
		Collections.sort(allMovies, new RatingComparator());
		showMovies("Movies with total ordering based on descending rating", allMovies);
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
