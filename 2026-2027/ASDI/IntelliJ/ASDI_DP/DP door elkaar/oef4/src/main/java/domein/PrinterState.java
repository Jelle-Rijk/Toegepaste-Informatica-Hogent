package domein;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class PrinterState {

    protected Printer printer;

    public void transitionTo(PrinterState nextState) {
        printer.setState(nextState);
    }

    public abstract String print(String bestandsnaam);

    public String cancel() {
        transitionTo(new End(printer));
        return "printen wordt geannuleerd";
    }

}