package domein;

public class End extends PrinterState {

    public End(Printer printer) {
        super(printer);
    }

    public String print(String bestandsnaam) {
        transitionTo(new Ready(printer));
        return "einde";
    }

    public String cancel() {
        throw new UnsupportedOperationException();
    }

}