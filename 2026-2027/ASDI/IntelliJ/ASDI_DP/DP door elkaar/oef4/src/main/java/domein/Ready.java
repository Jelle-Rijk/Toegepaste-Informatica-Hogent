package domein;

public class Ready extends PrinterState {

    public Ready(Printer printer) {
        super(printer);
    }

    public String print(String bestandsnaam) {
        transitionTo(new Start(printer));
        return "klaar om te printen";
    }

    public String cancel() {
        throw new UnsupportedOperationException();
    }

}