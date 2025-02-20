
package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domein.Movie;

public class ComparableApp {

	public void startSortMovies() {
		List<Movie> list = new ArrayList<Movie>();

		list.add(new Movie("Force Awakens", 8.3, 2015));
		list.add(new Movie("Force Awakens", 8.3, 2010));
		list.add(new Movie("Force Awakens", 8.3, 2000));
		list.add(new Movie("Star Wars", 8.7, 1977));
		list.add(new Movie("Empire Strikes Back", 8.8, 1980));
		list.add(new Movie("Return of the Jedi", 8.4, 1983));
		list.add(new Movie("Return of the Jedi", 8.4, 1999));
		list.add(new Movie("Return of the Jedi", 8.4, 2015));

		//list.sort(null);
		
		//OF:
		//Collections.sort(list);

		System.out.println("Movies na het sorteren: ");
		for (Movie movie : list) {
			System.out.println(movie);
		}
	}
}
