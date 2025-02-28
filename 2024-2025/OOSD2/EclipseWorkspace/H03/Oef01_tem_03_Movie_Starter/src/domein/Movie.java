package domein;

import java.util.Objects;

public class Movie implements Comparable<Movie> {

	private double rating;
	private String name;
	private int year;

	public Movie(String name, double rating, int year) {
		setName(name);
		setRating(rating);
		setYear(year);
	}

	public double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	private void setRating(double rating) {
		this.rating = rating;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return String.format("%-25s %5.2f %8d", name, rating, year);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(name, other.name) && year == other.year;
	}

	@Override
	public int compareTo(Movie m) {
		int compareName = name.compareTo(m.name);
		return compareName != 0 ? compareName : year - m.year;
	}

	public static int compareRating(Movie m1, Movie m2) {
		return Double.compare(m1.getRating(), m2.getRating()) * -1;
	}

	public static int compareName(Movie m1, Movie m2) {
		return m1.getName().compareTo(m2.getName());
	}
}
