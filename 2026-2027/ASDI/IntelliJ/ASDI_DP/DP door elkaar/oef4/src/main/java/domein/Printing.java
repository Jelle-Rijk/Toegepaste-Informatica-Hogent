package domein;

public class Printing extends PrinterState {

    public Printing(Printer printer) {
        super(printer);
    }

    public String print(String bestandsnaam) {
        transitionTo(new End(printer));
        return "bezig met printen " + bestandsnaam;
    }
}