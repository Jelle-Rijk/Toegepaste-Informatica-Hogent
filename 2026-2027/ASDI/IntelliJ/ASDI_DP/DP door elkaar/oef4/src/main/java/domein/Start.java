package domein;

public class Start extends PrinterState {

    public Start(Printer printer) {
        super(printer);
    }

    public String print(String bestandsnaam) {
        transitionTo(new Printing(printer));
        return "printen kan worden gestart";
    }

}