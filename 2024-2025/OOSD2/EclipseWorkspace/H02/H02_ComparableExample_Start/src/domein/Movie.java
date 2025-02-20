package domein;

public class Movie {

    private double rating;
    private String name;
    private int year;

    // Constructor 
    public Movie(String name, double rating, int year) {
        setName(name);
        setRating(rating);
        setYear(year);
    }
    
    // Getter & setter methods for accessing private data 
    public double getRating() { return rating; }
    public String getName() { return name; }
    public int getYear() { return year; }
    private void setRating(double rating) { this.rating = rating; }
    private void setName(String name) { this.name = name; }
    private void setYear(int year) { this.year = year; }

	@Override
	public String toString() {
		return String.format("%s %.2f %d", name, rating, year);
	}
}


