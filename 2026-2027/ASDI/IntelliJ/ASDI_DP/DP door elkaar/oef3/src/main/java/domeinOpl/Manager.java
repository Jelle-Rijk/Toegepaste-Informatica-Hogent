package domeinOpl;

public class Manager extends Bediende {
    private final double premie;

    public Manager(double maandwedde, double premie) {
        super(maandwedde);
        this.premie = premie;
    }

    @Override()
    public double geefJaarInkomst() {
        return super.geefJaarInkomst() + premie;
    }

}